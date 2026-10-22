package androidx.appcompat.view;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class SupportMenuInflater extends MenuInflater {
    static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = null;
    static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE = null;
    static final String LOG_TAG = "SupportMenuInflater";
    static final int NO_ID = 0;
    private static final String XML_GROUP = "group";
    private static final String XML_ITEM = "item";
    private static final String XML_MENU = "menu";
    final Object[] mActionProviderConstructorArguments;
    final Object[] mActionViewConstructorArguments;
    Context mContext;
    private Object mRealOwner;

    public static class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        private static final Class<?>[] PARAM_TYPES = null;
        private Method mMethod;
        private Object mRealOwner;

        static {
            PARAM_TYPES = new Class[]{MenuItem.class};
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem r6) {
        L8:
            e = move-exception;
            throw new RuntimeException(e);
        L3:
            if (this.mMethod.getReturnType() == Boolean.TYPE) goto L5;
            this.mMethod.invoke(this.mRealOwner, new Object[]{r6});     // Catch: Exception -> L8
            return true;
        L5:
            return ((Boolean) this.mMethod.invoke(this.mRealOwner, new Object[]{r6})).booleanValue();
        }

        public InflatedOnMenuItemClickListener(Object r5, String r6) {
            this.mRealOwner = r5;
            Class<?> r7 = r5.getClass();
            this.mMethod = r7.getMethod(r6, PARAM_TYPES);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            InflateException r1 = new InflateException("Couldn't resolve menu item onClick handler " + r6 + " in class " + r7.getName());
            r1.initCause(e);
            throw r1;
        }
    }

    public class MenuState {
        private static final int defaultGroupId = 0;
        private static final int defaultItemCategory = 0;
        private static final int defaultItemCheckable = 0;
        private static final boolean defaultItemChecked = false;
        private static final boolean defaultItemEnabled = true;
        private static final int defaultItemId = 0;
        private static final int defaultItemOrder = 0;
        private static final boolean defaultItemVisible = true;
        private int groupCategory;
        private int groupCheckable;
        private boolean groupEnabled;
        private int groupId;
        private int groupOrder;
        private boolean groupVisible;
        ActionProvider itemActionProvider;
        private String itemActionProviderClassName;
        private String itemActionViewClassName;
        private int itemActionViewLayout;
        private boolean itemAdded;
        private int itemAlphabeticModifiers;
        private char itemAlphabeticShortcut;
        private int itemCategoryOrder;
        private int itemCheckable;
        private boolean itemChecked;
        private CharSequence itemContentDescription;
        private boolean itemEnabled;
        private int itemIconResId;
        private ColorStateList itemIconTintList;
        private PorterDuff.Mode itemIconTintMode;
        private int itemId;
        private String itemListenerMethodName;
        private int itemNumericModifiers;
        private char itemNumericShortcut;
        private int itemShowAsAction;
        private CharSequence itemTitle;
        private CharSequence itemTitleCondensed;
        private CharSequence itemTooltipText;
        private boolean itemVisible;
        private Menu menu;
        final /* synthetic */ SupportMenuInflater this$0;

        public static /* synthetic */ Class access$000(String r0, boolean r1, ClassLoader r2) throws ClassNotFoundException {
            return Class.forName(r0, r1, r2);
        }

        public void addItem() {
            this.itemAdded = true;
            setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
        }

        public SubMenu addSubMenuItem() {
            this.itemAdded = true;
            SubMenu r0 = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
            setItem(r0.getItem());
            return r0;
        }

        public void resetGroup() {
            this.groupId = 0;
            this.groupCategory = 0;
            this.groupOrder = 0;
            this.groupCheckable = 0;
            this.groupVisible = true;
            this.groupEnabled = true;
        }

        public boolean hasAddedItem() {
            return this.itemAdded;
        }

        private char getShortcut(String r2) {
            if (r2 != null) goto L6;
            return 0;
        L6:
            return r2.charAt(0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void setItem(MenuItem r6) {
            MenuItem r0 = r6.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled);
            boolean r2 = false;
            if (this.itemCheckable < 1) goto L5;
            boolean r1 = true;
        L6:
            r0.setCheckable(r1).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId);
            int r3 = this.itemShowAsAction;
            if (r3 < 0) goto L10;
            r6.setShowAsAction(r3);
        L10:
            if (this.itemListenerMethodName == null) goto L17;
            if (this.this$0.mContext.isRestricted() == true) goto L15;
            r6.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(this.this$0.getRealOwner(), this.itemListenerMethodName));
            goto L17
        L15:
            throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
        L17:
            if (this.itemCheckable < 2) goto L25;
            if ((r6 instanceof MenuItemImpl) == false) goto L22;
            ((MenuItemImpl) r6).setExclusiveCheckable(true);
            goto L25
        L22:
            if ((r6 instanceof MenuItemWrapperICS) == false) goto L25;
            ((MenuItemWrapperICS) r6).setExclusiveCheckable(true);
        L25:
            if (this.itemActionViewClassName == null) goto L27;
            r6.setActionView((View) newInstance(this.itemActionViewClassName, SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, this.this$0.mActionViewConstructorArguments));
            r2 = true;
        L27:
            int r4 = this.itemActionViewLayout;
            if (r4 <= 0) goto L31;
            if (r2 == true) goto L31;
            r6.setActionView(r4);
        L31:
            ActionProvider r5 = this.itemActionProvider;
            if (r5 == null) goto L34;
            MenuItemCompat.setActionProvider(r6, r5);
        L34:
            MenuItemCompat.setContentDescription(r6, this.itemContentDescription);
            MenuItemCompat.setTooltipText(r6, this.itemTooltipText);
            MenuItemCompat.setAlphabeticShortcut(r6, this.itemAlphabeticShortcut, this.itemAlphabeticModifiers);
            MenuItemCompat.setNumericShortcut(r6, this.itemNumericShortcut, this.itemNumericModifiers);
            PorterDuff.Mode r7 = this.itemIconTintMode;
            if (r7 == null) goto L37;
            MenuItemCompat.setIconTintMode(r6, r7);
        L37:
            ColorStateList r8 = this.itemIconTintList;
            if (r8 == null) goto L41;
            MenuItemCompat.setIconTintList(r6, r8);
            return;
        L41:
            return;
        L5:
            r1 = false;
            goto L6
        }

        public void readGroup(AttributeSet r4) {
            TypedArray r5 = this.this$0.mContext.obtainStyledAttributes(r4, new int[]{R.attr.enabled, R.attr.id, R.attr.visible, R.attr.menuCategory, R.attr.orderInCategory, R.attr.checkableBehavior});
            this.groupId = r5.getResourceId(1, 0);
            this.groupCategory = r5.getInt(3, 0);
            this.groupOrder = r5.getInt(4, 0);
            this.groupCheckable = r5.getInt(5, 0);
            this.groupVisible = r5.getBoolean(2, true);
            this.groupEnabled = r5.getBoolean(0, true);
            r5.recycle();
        }

        public void readItem(AttributeSet r7) {
            TintTypedArray r8 = TintTypedArray.obtainStyledAttributes(this.this$0.mContext, r7, new int[]{R.attr.icon, R.attr.enabled, R.attr.id, R.attr.checked, R.attr.visible, R.attr.menuCategory, R.attr.orderInCategory, R.attr.title, R.attr.titleCondensed, R.attr.alphabeticShortcut, R.attr.numericShortcut, R.attr.checkable, R.attr.onClick, 2130968723, 2130968743, 2130968745, 2130968784, 2130969619, 2130970297, 2130970299, 2130972845, 2130974051, 2130974613});
            this.itemId = r8.getResourceId(2, 0);
            int r0 = r8.getInt(5, this.groupCategory);
            this.itemCategoryOrder = (r0 & (-65536)) | (r8.getInt(6, this.groupOrder) & 65535);
            this.itemTitle = r8.getText(7);
            this.itemTitleCondensed = r8.getText(8);
            this.itemIconResId = r8.getResourceId(0, 0);
            this.itemAlphabeticShortcut = getShortcut(r8.getString(9));
            this.itemAlphabeticModifiers = r8.getInt(16, 4096);
            this.itemNumericShortcut = getShortcut(r8.getString(10));
            this.itemNumericModifiers = r8.getInt(20, 4096);
            if (r8.hasValue(11) == false) goto L5;
            this.itemCheckable = r8.getBoolean(11, false) ? 1 : 0;
        L6:
            this.itemChecked = r8.getBoolean(3, false);
            this.itemVisible = r8.getBoolean(4, this.groupVisible);
            boolean r2 = true;
            this.itemEnabled = r8.getBoolean(1, this.groupEnabled);
            this.itemShowAsAction = r8.getInt(21, -1);
            this.itemListenerMethodName = r8.getString(12);
            this.itemActionViewLayout = r8.getResourceId(13, 0);
            this.itemActionViewClassName = r8.getString(15);
            String r1 = r8.getString(14);
            this.itemActionProviderClassName = r1;
            if (r1 != null) goto L11;
            r2 = false;
        L11:
            if (r2 == true) goto L13;
        L17:
            this.itemActionProvider = null;
        L18:
            this.itemContentDescription = r8.getText(17);
            this.itemTooltipText = r8.getText(22);
            if (r8.hasValue(19) == false) goto L21;
            this.itemIconTintMode = DrawableUtils.parseTintMode(r8.getInt(19, -1), this.itemIconTintMode);
        L23:
            if (r8.hasValue(18) == false) goto L25;
            this.itemIconTintList = r8.getColorStateList(18);
        L26:
            r8.recycle();
            this.itemAdded = false;
            return;
        L25:
            this.itemIconTintList = null;
            goto L26
        L21:
            this.itemIconTintMode = null;
            goto L23
        L13:
            if (this.itemActionViewLayout != 0) goto L17;
            if (this.itemActionViewClassName != null) goto L17;
            this.itemActionProvider = (ActionProvider) newInstance(this.itemActionProviderClassName, SupportMenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, this.this$0.mActionProviderConstructorArguments);
            goto L18
        L5:
            this.itemCheckable = this.groupCheckable;
            goto L6
        }

        public MenuState(SupportMenuInflater r1, Menu r2) {
            this.this$0 = r1;
            this.itemIconTintList = null;
            this.itemIconTintMode = null;
            this.menu = r2;
            resetGroup();
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_androidx_appcompat_view_SupportMenuInflater$MenuState_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r2, boolean r3, ClassLoader r4) throws ClassNotFoundException {
            ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
            FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (a.a() == true) goto L34;
            Class r5 = access$000(r2, r3, r4);     // Catch: Throwable -> L8
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r2);     // Catch: Throwable -> L8
        L7:
            return r5;
        L8:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r2);
        L12:
            throw th;
        L34:
            Class r6 = access$000(r2, r3, r4);     // Catch: Throwable -> L17
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r2);     // Catch: Throwable -> L17
        L16:
            return r6;
        L17:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r2);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r2);
        }

        private <T> T newInstance(String r3, Class<?>[] r4, Object[] r5) {
            Constructor<T> r6 = INVOKESTATIC_androidx_appcompat_view_SupportMenuInflater$MenuState_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r3, false, this.this$0.mContext.getClassLoader()).getConstructor(r4);     // Catch: Exception -> L4
            r6.setAccessible(true);     // Catch: Exception -> L4
            return r6.newInstance(r5);
        L5:
            return null;
        }
    }

    static {
        Class<?>[] r0 = {Context.class};
        ACTION_VIEW_CONSTRUCTOR_SIGNATURE = r0;
        ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = r0;
    }

    public Object getRealOwner() {
        if (this.mRealOwner != null) goto L6;
        this.mRealOwner = findRealOwner(this.mContext);
    L6:
        return this.mRealOwner;
    }

    public SupportMenuInflater(Context r3) {
        super(r3);
        this.mContext = r3;
        Object[] r0 = {r3};
        this.mActionViewConstructorArguments = r0;
        this.mActionProviderConstructorArguments = r0;
    }

    private Object findRealOwner(Object r2) {
        if ((r2 instanceof Activity) == false) goto L6;
        return r2;
    L6:
        if ((r2 instanceof ContextWrapper) == true) goto L8;
        return r2;
    L8:
        return findRealOwner(((ContextWrapper) r2).getBaseContext());
    }

    @Override // android.view.MenuInflater
    public void inflate(int r4, Menu r5) {
        if ((r5 instanceof SupportMenu) == true) goto L6;
        super.inflate(r4, r5);
        return;
    L6:
        XmlResourceParser r1 = null;
        r1 = this.mContext.getResources().getLayout(r4);     // Catch: Throwable -> L11 IOException -> L13 XmlPullParserException -> L16
        parseMenu(r1, Xml.asAttributeSet(r1), r5);     // Catch: Throwable -> L11 IOException -> L13 XmlPullParserException -> L16
        if (r1 == null) goto L24;
        r1.close();
        return;
    L24:
        return;
    L11:
        th = move-exception;
        if (r1 == null) goto L21;
        r1.close();
    L21:
        throw th;
    L16:
        e = move-exception;
        throw new InflateException("Error inflating menu XML", e);     // Catch: Throwable -> L11
    L13:
        e = move-exception;
        throw new InflateException("Error inflating menu XML", e);     // Catch: Throwable -> L11
    }

    private void parseMenu(XmlPullParser r13, AttributeSet r14, Menu r15) throws XmlPullParserException, IOException {
        MenuState r0 = new MenuState(this, r15);
        int r16 = r13.getEventType();
    L4:
        if (r16 == 2) goto L5;
        r16 = r13.next();
        if (r16 != 1) goto L4;
    L12:
        String r8 = null;
        boolean r6 = false;
        boolean r7 = false;
    L13:
        if (r6 == true) goto L56;
        if (r16 == 1) goto L55;
        if (r16 != 2) goto L18;
        if (r7 == true) goto L53;
        String r17 = r13.getName();
        if (r17.equals(XML_GROUP) == false) goto L47;
        r0.readGroup(r14);
        goto L53
    L47:
        if (r17.equals(XML_ITEM) == false) goto L50;
        r0.readItem(r14);
        goto L53
    L50:
        if (r17.equals(XML_MENU) == false) goto L52;
        parseMenu(r13, r14, r0.addSubMenuItem());
        goto L53
    L52:
        r8 = r17;
        r7 = true;
    L53:
        r16 = r13.next();
        goto L13
    L18:
        if (r16 != 3) goto L53;
        String r18 = r13.getName();
        if (r7 == false) goto L26;
        if (r18.equals(r8) == false) goto L26;
        r8 = null;
        r7 = false;
    L26:
        if (r18.equals(XML_GROUP) == false) goto L29;
        r0.resetGroup();
        goto L53
    L29:
        if (r18.equals(XML_ITEM) == false) goto L39;
        if (r0.hasAddedItem() == true) goto L53;
        ActionProvider r19 = r0.itemActionProvider;
        if (r19 != null) goto L35;
    L37:
        r0.addItem();
        goto L53
    L35:
        if (r19.hasSubMenu() == false) goto L37;
        r0.addSubMenuItem();
        goto L53
    L39:
        if (r18.equals(XML_MENU) == false) goto L53;
        r6 = true;
        goto L53
    L55:
        throw new RuntimeException("Unexpected end of document");
    L56:
        return;
    L5:
        String r110 = r13.getName();
        if (r110.equals(XML_MENU) == false) goto L9;
        r16 = r13.next();
        goto L12
    L9:
        throw new RuntimeException("Expecting menu, got ".concat(r110));
    }
}
