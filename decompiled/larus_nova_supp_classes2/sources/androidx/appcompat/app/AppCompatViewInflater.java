package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.View;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.ViewCompat;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AppCompatViewInflater {
    private static final String LOG_TAG = "AppCompatViewInflater";
    private static final String[] sClassPrefixList = null;
    private static final SimpleArrayMap<String, Constructor<? extends View>> sConstructorMap = null;
    private static final Class<?>[] sConstructorSignature = null;
    private static final int[] sOnClickAttrs = null;
    private final Object[] mConstructorArgs;

    public static class DeclaredOnClickListener implements View.OnClickListener {
        private final View mHostView;
        private final String mMethodName;
        private Context mResolvedContext;
        private Method mResolvedMethod;

        private void resolveMethod(Context r6) {
        L2:
            if (r6 == null) goto L14;
            if (r6.isRestricted() == true) goto L11;
            Method r0 = r6.getClass().getMethod(this.mMethodName, new Class[]{View.class});     // Catch: NoSuchMethodException -> L9
            if (r0 == null) goto L11;
            this.mResolvedMethod = r0;     // Catch: NoSuchMethodException -> L9
            this.mResolvedContext = r6;     // Catch: NoSuchMethodException -> L9
            return;
        L11:
            if ((r6 instanceof ContextWrapper) == true) goto L12;
            r6 = null;
            goto L2
        L12:
            r6 = ((ContextWrapper) r6).getBaseContext();
            goto L2
        L14:
            int r7 = this.mHostView.getId();
            if (r7 != (-1)) goto L17;
            String r8 = "";
        L19:
            throw new IllegalStateException("Could not find method " + this.mMethodName + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.mHostView.getClass() + r8);
        L17:
            r8 = " with id '" + this.mHostView.getContext().getResources().getResourceEntryName(r7) + "'";
            goto L19
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r5) {
            if (this.mResolvedMethod != null) goto L13;
            resolveMethod(this.mHostView.getContext());
        L13:
            this.mResolvedMethod.invoke(this.mResolvedContext, new Object[]{r5});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L10
            return;
        L10:
            e = move-exception;
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
        L7:
            e = move-exception;
            throw new IllegalStateException("Could not execute method for android:onClick", e);
        }

        public DeclaredOnClickListener(View r1, String r2) {
            this.mHostView = r1;
            this.mMethodName = r2;
        }
    }

    static {
        sConstructorSignature = new Class[]{Context.class, AttributeSet.class};
        sOnClickAttrs = new int[]{R.attr.onClick};
        sClassPrefixList = new String[]{"android.widget.", "android.view.", "android.webkit."};
        sConstructorMap = new SimpleArrayMap();
    }

    public static /* synthetic */ Class access$000(String r0, boolean r1, ClassLoader r2) throws ClassNotFoundException {
        return Class.forName(r0, r1, r2);
    }

    public View createView(Context r1, String r2, AttributeSet r3) {
        return null;
    }

    public AppCompatViewInflater() {
        this.mConstructorArgs = new Object[2];
    }

    private void checkOnClickListener(View r3, AttributeSet r4) {
        Context r0 = r3.getContext();
        if ((r0 instanceof ContextWrapper) == true) goto L5;
        return;
    L5:
        if (ViewCompat.hasOnClickListeners(r3) == false) goto L13;
        TypedArray r5 = r0.obtainStyledAttributes(r4, sOnClickAttrs);
        String r1 = r5.getString(0);
        if (r1 == null) goto L10;
        r3.setOnClickListener(new DeclaredOnClickListener(r3, r1));
    L10:
        r5.recycle();
        return;
    }

    private void verifyNotNull(View r3, String r4) {
        if (r3 == null) goto L5;
        return;
    L5:
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + r4 + ">, but returned null");
    }

    public AppCompatAutoCompleteTextView createAutoCompleteTextView(Context r2, AttributeSet r3) {
        return new AppCompatAutoCompleteTextView(r2, r3);
    }

    public AppCompatButton createButton(Context r2, AttributeSet r3) {
        return new AppCompatButton(r2, r3);
    }

    public AppCompatCheckBox createCheckBox(Context r2, AttributeSet r3) {
        return new AppCompatCheckBox(r2, r3);
    }

    public AppCompatCheckedTextView createCheckedTextView(Context r2, AttributeSet r3) {
        return new AppCompatCheckedTextView(r2, r3);
    }

    public AppCompatEditText createEditText(Context r2, AttributeSet r3) {
        return new AppCompatEditText(r2, r3);
    }

    public AppCompatImageButton createImageButton(Context r2, AttributeSet r3) {
        return new AppCompatImageButton(r2, r3);
    }

    public AppCompatImageView createImageView(Context r2, AttributeSet r3) {
        return new AppCompatImageView(r2, r3);
    }

    public AppCompatMultiAutoCompleteTextView createMultiAutoCompleteTextView(Context r2, AttributeSet r3) {
        return new AppCompatMultiAutoCompleteTextView(r2, r3);
    }

    public AppCompatRadioButton createRadioButton(Context r2, AttributeSet r3) {
        return new AppCompatRadioButton(r2, r3);
    }

    public AppCompatRatingBar createRatingBar(Context r2, AttributeSet r3) {
        return new AppCompatRatingBar(r2, r3);
    }

    public AppCompatSeekBar createSeekBar(Context r2, AttributeSet r3) {
        return new AppCompatSeekBar(r2, r3);
    }

    public AppCompatSpinner createSpinner(Context r2, AttributeSet r3) {
        return new AppCompatSpinner(r2, r3);
    }

    public AppCompatTextView createTextView(Context r2, AttributeSet r3) {
        return new AppCompatTextView(r2, r3);
    }

    public AppCompatToggleButton createToggleButton(Context r2, AttributeSet r3) {
        return new AppCompatToggleButton(r2, r3);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_appcompat_app_AppCompatViewInflater_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r2, boolean r3, ClassLoader r4) throws ClassNotFoundException {
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

    private View createViewByPrefix(Context r3, String r4, String r5) throws ClassNotFoundException, InflateException {
        SimpleArrayMap<String, Constructor<? extends View>> r0 = sConstructorMap;
        Constructor r1 = (Constructor) r0.get(r4);
        if (r1 != null) goto L8;
        if (r5 != null) goto L12;
        String r6 = r4;
    L7:
        r1 = INVOKESTATIC_androidx_appcompat_app_AppCompatViewInflater_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r6, false, r3.getClassLoader()).asSubclass(View.class).getConstructor(sConstructorSignature);     // Catch: Exception -> L10
        r0.put(r4, r1);     // Catch: Exception -> L10
        goto L8
    L12:
        r6 = r5 + r4;     // Catch: Exception -> L10
    L10:
        return null;
    L8:
        r1.setAccessible(true);     // Catch: Exception -> L10
        return (View) r1.newInstance(this.mConstructorArgs);
    }

    private View createViewFromTag(Context r6, String r7, AttributeSet r8) {
        if (r7.equals("view") == false) goto L26;
        r7 = r8.getAttributeValue(null, "class");
    L26:
        Object[] r3 = this.mConstructorArgs;     // Catch: Throwable -> L21 Exception -> L24
        r3[0] = r6;     // Catch: Throwable -> L21 Exception -> L24
        r3[1] = r8;     // Catch: Throwable -> L21 Exception -> L24
        if ((-1) != r7.indexOf(46)) goto L18;
        int r9 = 0;
    L9:
        String[] r4 = sClassPrefixList;     // Catch: Throwable -> L21 Exception -> L24
        if (r9 >= r4.length) goto L16;
        View r5 = createViewByPrefix(r6, r7, r4[r9]);     // Catch: Throwable -> L21 Exception -> L24
        if (r5 != null) goto L13;
        r9 = r9 + 1;
        goto L9
    L13:
        Object[] r10 = this.mConstructorArgs;
        r10[0] = null;
        r10[1] = null;
        return r5;
    L16:
        Object[] r11 = this.mConstructorArgs;
        r11[0] = null;
        r11[1] = null;
        return null;
    L18:
        View r12 = createViewByPrefix(r6, r7, null);     // Catch: Throwable -> L21 Exception -> L24
        Object[] r13 = this.mConstructorArgs;
        r13[0] = null;
        r13[1] = null;
        return r12;
    L24:
        Object[] r14 = this.mConstructorArgs;
        r14[0] = null;
        r14[1] = null;
        return null;
    L21:
        th = move-exception;
        Object[] r15 = this.mConstructorArgs;
        r15[0] = null;
        r15[1] = null;
        throw th;
    }

    private static Context themifyContext(Context r2, AttributeSet r3, boolean r4, boolean r5) {
        TypedArray r6 = r2.obtainStyledAttributes(r3, new int[]{R.attr.theme, R.attr.focusable, 2130973429, 2130973430, 2130974553}, 0, 0);
        if (r4 == false) goto L5;
        int r7 = r6.getResourceId(0, 0);
    L6:
        if (r5 == false) goto L9;
        if (r7 != 0) goto L9;
        r7 = r6.getResourceId(4, 0);
    L9:
        r6.recycle();
        if (r7 != 0) goto L12;
        return r2;
    L12:
        if ((r2 instanceof ContextThemeWrapper) == false) goto L16;
        if (((ContextThemeWrapper) r2).getThemeResId() != r7) goto L16;
        return r2;
    L16:
        return new ContextThemeWrapper(r2, r7);
    L5:
        r7 = 0;
        goto L6
    }

    public final View createView(View r1, String r2, Context r3, AttributeSet r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        if (r5 == false) goto L5;
        if (r1 == null) goto L5;
        Context r9 = r1.getContext();
    L6:
        if (r6 == true) goto L8;
        if (r7 == true) goto L8;
    L9:
        if (r8 == false) goto L11;
        r9 = TintContextWrapper.wrap(r9);
    L11:
        r2.getClass();
        byte r10 = -1;
        switch(r2.hashCode()) {
            case -1946472170: goto L67;
            case -1455429095: goto L63;
            case -1346021293: goto L59;
            case -938935918: goto L55;
            case -937446323: goto L51;
            case -658531749: goto L47;
            case -339785223: goto L43;
            case 776382189: goto L39;
            case 799298502: goto L35;
            case 1125864064: goto L31;
            case 1413872058: goto L27;
            case 1601505219: goto L23;
            case 1666676343: goto L19;
            case 2001146706: goto L15;
            default: goto L70;
        };
    L70:
        switch(r10) {
            case 0: goto L85;
            case 1: goto L84;
            case 2: goto L83;
            case 3: goto L82;
            case 4: goto L81;
            case 5: goto L80;
            case 6: goto L79;
            case 7: goto L78;
            case 8: goto L77;
            case 9: goto L76;
            case 10: goto L75;
            case 11: goto L74;
            case 12: goto L73;
            case 13: goto L72;
            default: goto L71;
        };
    L71:
        View r11 = createView(r9, r2, r4);
    L86:
        if (r11 != null) goto L89;
        if (r3 == r9) goto L89;
        r11 = createViewFromTag(r9, r2, r4);
    L89:
        if (r11 == null) goto L91;
        checkOnClickListener(r11, r4);
    L91:
        return r11;
    L72:
        r11 = createButton(r9, r4);
        verifyNotNull(r11, r2);
        goto L86
    L73:
        r11 = createEditText(r9, r4);
        verifyNotNull(r11, r2);
        goto L86
    L74:
        r11 = createCheckBox(r9, r4);
        verifyNotNull(r11, r2);
        goto L86
    L75:
        r11 = createAutoCompleteTextView(r9, r4);
        verifyNotNull(r11, r2);
        goto L86
    L76:
        r11 = createImageView(r9, r4);
        verifyNotNull(r11, r2);
        goto L86
    L77:
        r11 = createToggleButton(r9, r4);
        verifyNotNull(r11, r2);
        goto L86
    L78:
        r11 = createRadioButton(r9, r4);
        verifyNotNull(r11, r2);
        goto L86
    L79:
        r11 = createSpinner(r9, r4);
        verifyNotNull(r11, r2);
        goto L86
    L80:
        r11 = createSeekBar(r9, r4);
        verifyNotNull(r11, r2);
        goto L86
    L81:
        r11 = createImageButton(r9, r4);
        verifyNotNull(r11, r2);
        goto L86
    L82:
        r11 = createTextView(r9, r4);
        verifyNotNull(r11, r2);
        goto L86
    L83:
        r11 = createMultiAutoCompleteTextView(r9, r4);
        verifyNotNull(r11, r2);
        goto L86
    L84:
        r11 = createCheckedTextView(r9, r4);
        verifyNotNull(r11, r2);
        goto L86
    L85:
        r11 = createRatingBar(r9, r4);
        verifyNotNull(r11, r2);
        goto L86
    L15:
        if (r2.equals("Button") == false) goto L70;
        r10 = 13;
        goto L70
    L19:
        if (r2.equals("EditText") == false) goto L70;
        r10 = 12;
        goto L70
    L23:
        if (r2.equals("CheckBox") == false) goto L70;
        r10 = 11;
        goto L70
    L27:
        if (r2.equals("AutoCompleteTextView") == false) goto L70;
        r10 = 10;
        goto L70
    L31:
        if (r2.equals("ImageView") == false) goto L70;
        r10 = 9;
        goto L70
    L35:
        if (r2.equals("ToggleButton") == false) goto L70;
        r10 = 8;
        goto L70
    L39:
        if (r2.equals("RadioButton") == false) goto L70;
        r10 = 7;
        goto L70
    L43:
        if (r2.equals("Spinner") == false) goto L70;
        r10 = 6;
        goto L70
    L47:
        if (r2.equals("SeekBar") == false) goto L70;
        r10 = 5;
        goto L70
    L51:
        if (r2.equals("ImageButton") == false) goto L70;
        r10 = 4;
        goto L70
    L55:
        if (r2.equals("TextView") == false) goto L70;
        r10 = 3;
        goto L70
    L59:
        if (r2.equals("MultiAutoCompleteTextView") == false) goto L70;
        r10 = 2;
        goto L70
    L63:
        if (r2.equals("CheckedTextView") == false) goto L70;
        r10 = 1;
        goto L70
    L67:
        if (r2.equals("RatingBar") == false) goto L70;
        r10 = 0;
    L8:
        r9 = themifyContext(r9, r4, r6, r7);
    L5:
        r9 = r3;
        goto L6
    }
}
