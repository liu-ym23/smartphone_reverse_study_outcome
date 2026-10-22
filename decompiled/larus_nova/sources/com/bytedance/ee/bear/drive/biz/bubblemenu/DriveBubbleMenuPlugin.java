package com.bytedance.ee.bear.drive.biz.bubblemenu;

import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.biz.preview.DrivePreviewContentPlugin;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView;
import com.bytedance.ee.plugin.common.ttpdfreader.TTReaderSelectionInfo;
import com.larus.platform.api.creation.TplType;
import java.util.Iterator;
import java.util.List;
import jdb.g;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u001d\u001a\u00020\u0010H\u0002J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/bubblemenu/DriveBubbleMenuPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "actionMode", "Landroid/view/ActionMode;", "popMenuRect", "Landroid/graphics/RectF;", "bubbleMenuVM", "Lcom/bytedance/ee/bear/drive/biz/bubblemenu/BubbleMenuVM;", "menuItems", "", "Lcom/bytedance/ee/bear/drive/biz/bubblemenu/BubbleMenuItem;", "keyboardHeight", "", "hasHardKeyboard", "", "keyboardObserverRegistered", "keyboardHeightProvider", "Lcom/ss/android/lark/edit/keyboard/provider/KeyboardHeightProvider;", "keyboardHeightObserver", "Lcom/ss/android/lark/edit/keyboard/KeyboardHeightObserver;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onDetachFromHost", "startActionMode", "updateActionMode", "shouldSuppressMenu", "isKeyboardObserverEnabled", "finishActionMode", "reason", "", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveBubbleMenuPlugin extends AbsDrivePlugin {
    public static final a Companion = null;
    private static final int DRIVE_BUBBLE_MENU_GROUP_ID = 1146243414;
    private static final int HARD_KEYBOARD_PLACEHOLDER_HEIGHT = 1;
    private static final long MENU_HIDE_DURATION = 300;
    private static final String TAG = "DriveBubbleMenuPlugin";
    private ActionMode actionMode;
    private BubbleMenuVM bubbleMenuVM;
    private boolean hasHardKeyboard;
    private int keyboardHeight;
    private final ocb.a keyboardHeightObserver;
    private pcb.a keyboardHeightProvider;
    private boolean keyboardObserverRegistered;
    private List<com.bytedance.ee.bear.drive.biz.bubblemenu.c> menuItems;
    private RectF popMenuRect;

    public static final class a {
        public a() {
        }

        public static void a(Menu r100, List r101) {
            Intrinsics.checkNotNullParameter(r100, TplType.MENU);
            r100.removeGroup(DriveBubbleMenuPlugin.DRIVE_BUBBLE_MENU_GROUP_ID);
            if (r101 != null) goto L5;
            r101 = CollectionsKt.emptyList();
        L5:
            Iterator r102 = r101.iterator();
        L7:
            if (r102.hasNext() == false) goto L11;
            com.bytedance.ee.bear.drive.biz.bubblemenu.c r103 = (com.bytedance.ee.bear.drive.biz.bubblemenu.c) r102.next();
            if (r103.f222608d.invoke(r103.f222605a).booleanValue() == false) goto L7;
            r100.add(DriveBubbleMenuPlugin.DRIVE_BUBBLE_MENU_GROUP_ID, r103.f222605a.hashCode(), r103.f222607c, r103.f222606b);
            goto L7
        }
    }

    public static final class b implements ocb.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DriveBubbleMenuPlugin f222599a;

        public b(DriveBubbleMenuPlugin r100) {
            this.f222599a = r100;
        }

        @Override // ocb.a
        public final void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
            boolean r103 = DriveBubbleMenuPlugin.access$shouldSuppressMenu(this.f222599a);
            DriveBubbleMenuPlugin.access$setKeyboardHeight$p(this.f222599a, r101);
            DriveBubbleMenuPlugin r104 = this.f222599a;
            DriveBubbleMenuPlugin.access$setHasHardKeyboard$p(r104, rcb.b.a(DriveBubbleMenuPlugin.access$getActivity(r104)));
            boolean r105 = DriveBubbleMenuPlugin.access$shouldSuppressMenu(this.f222599a);
            if (r103 == r105) goto L10;
            StringBuilder r106 = new StringBuilder("onKeyboardVisibilityChanged, isShowing=");
            r106.append(r105);
            r106.append(", height=");
            r106.append(DriveBubbleMenuPlugin.access$getKeyboardHeight$p(this.f222599a));
            r106.append(", hasHardKeyboard=");
            r106.append(DriveBubbleMenuPlugin.access$getHasHardKeyboard$p(this.f222599a));
            r106.append(", orientation=");
            r106.append(r102);
            r106.append(", hasActionMode=");
            if (DriveBubbleMenuPlugin.access$getActionMode$p(this.f222599a) == null) goto L7;
            boolean r107 = true;
        L8:
            r106.append(r107);
            tt5.a.h(DriveBubbleMenuPlugin.TAG, r106.toString());
            goto L10
        L7:
            r107 = false;
        L10:
            if (DriveBubbleMenuPlugin.access$shouldSuppressMenu(this.f222599a) == false) goto L13;
            DriveBubbleMenuPlugin.access$finishActionMode(this.f222599a, "keyboard_shown");
            return;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DriveBubbleMenuPlugin f222600a;

        public c(DriveBubbleMenuPlugin r100) {
            this.f222600a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            com.bytedance.ee.bear.drive.biz.bubblemenu.d r101 = (com.bytedance.ee.bear.drive.biz.bubblemenu.d) r100;
            tt5.a.h(DriveBubbleMenuPlugin.TAG, "onSelectionChanged, " + r101);
            StringBuilder r102 = new StringBuilder();
            if (r101 == null) goto L13;
            List<TTReaderSelectionInfo> r103 = r101.f222610a;
            if (r103 == null) goto L13;
            Iterator<T> r104 = r103.iterator();
        L8:
            if (r104.hasNext() == false) goto L13;
            String r105 = ((TTReaderSelectionInfo) r104.next()).selectedText;
            if (r105 != null) goto L12;
            r105 = "";
        L12:
            r102.append(r105);
        L13:
            String r106 = r102.toString();
            RectF r107 = null;
            if (r101 == null) goto L18;
            Bundle r108 = r101.f222611b;
            if (r108 == null) goto L18;
            RectF r109 = (RectF) r108.getParcelable("selectionRect");
        L20:
            if ((r109 instanceof RectF) == false) goto L22;
            r107 = r109;
        L22:
            if (r107 != null) goto L24;
            r107 = new RectF();
        L24:
            if (r101 != null) goto L26;
        L37:
            DriveBubbleMenuPlugin.access$finishActionMode(this.f222600a, "invalid_selection");
            return;
        L26:
            if (r106.length() != 0) goto L28;
            boolean r110 = true;
        L29:
            if (r110 == true) goto L37;
            if (r107.isEmpty() == true) goto L37;
            DriveBubbleMenuPlugin.access$setPopMenuRect$p(this.f222600a, r107);
            ActionMode r111 = DriveBubbleMenuPlugin.access$getActionMode$p(this.f222600a);
            if (r111 == null) goto L36;
            DriveBubbleMenuPlugin.access$updateActionMode(this.f222600a, r111);
            return;
        L36:
            DriveBubbleMenuPlugin.access$startActionMode(this.f222600a);
            return;
        L28:
            r110 = false;
        L18:
            r109 = null;
            goto L20
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DriveBubbleMenuPlugin f222601a;

        public d(DriveBubbleMenuPlugin r100) {
            this.f222601a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            DriveBubbleMenuPlugin r101 = this.f222601a;
            DriveBubbleMenuPlugin.access$setMenuItems$p(r101, (List) r100);
            ActionMode r102 = DriveBubbleMenuPlugin.access$getActionMode$p(this.f222601a);
            if (r102 == null) goto L6;
            r102.invalidate();
            return;
        }
    }

    public static final class e implements com.bytedance.ee.bear.drive.biz.bubblemenu.a.InterfaceActionModeCallbackC3173a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DriveBubbleMenuPlugin f222602a;

        public e(DriveBubbleMenuPlugin r100) {
            this.f222602a = r100;
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode r100) {
            Intrinsics.checkNotNullParameter(r100, "actionMode");
            tt5.a.h(DriveBubbleMenuPlugin.TAG, "onDestroyActionMode");
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
            Intrinsics.checkNotNullParameter(r100, "actionMode");
            Intrinsics.checkNotNullParameter(r101, "menuItem");
            tt5.a.h(DriveBubbleMenuPlugin.TAG, "onActionItemClicked");
            List r102 = DriveBubbleMenuPlugin.access$getMenuItems$p(this.f222602a);
            if (r102 == null) goto L14;
            Iterator r103 = r102.iterator();
        L6:
            if (r103.hasNext() == false) goto L10;
            Object r104 = r103.next();
            if (Intrinsics.areEqual(((com.bytedance.ee.bear.drive.biz.bubblemenu.c) r104).f222606b, r101.getTitle()) == false) goto L6;
        L11:
            com.bytedance.ee.bear.drive.biz.bubblemenu.c r105 = (com.bytedance.ee.bear.drive.biz.bubblemenu.c) r104;
            if (r105 == null) goto L14;
            r105.f222609e.invoke(r105.f222605a);
            goto L14
        L10:
            r104 = null;
        L14:
            DriveBubbleMenuPlugin.access$finishActionMode(this.f222602a, "menu_item_clicked");
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode r100, Menu r101) {
            Intrinsics.checkNotNullParameter(r100, "actionMode");
            Intrinsics.checkNotNullParameter(r101, TplType.MENU);
            tt5.a.h(DriveBubbleMenuPlugin.TAG, "onCreateActionMode");
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode r100, Menu r101) {
            Intrinsics.checkNotNullParameter(r100, "actionMode");
            Intrinsics.checkNotNullParameter(r101, TplType.MENU);
            a r102 = DriveBubbleMenuPlugin.Companion;
            List r103 = DriveBubbleMenuPlugin.access$getMenuItems$p(this.f222602a);
            r102.getClass();
            a.a(r101, r103);
            tt5.a.h(DriveBubbleMenuPlugin.TAG, "onPrepareActionMode");
            return true;
        }

        @Override // com.bytedance.ee.bear.drive.biz.bubblemenu.a.InterfaceActionModeCallbackC3173a
        public final void onGetContentRect(ActionMode r100, View r101, Rect r102) {
            Intrinsics.checkNotNullParameter(r100, "mode");
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "outRect");
            RectF r103 = DriveBubbleMenuPlugin.access$getPopMenuRect$p(this.f222602a);
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = (int) r103.left;
        L6:
            RectF r106 = DriveBubbleMenuPlugin.access$getPopMenuRect$p(this.f222602a);
            if (r106 == null) goto L9;
            int r107 = (int) r106.top;
        L10:
            RectF r108 = DriveBubbleMenuPlugin.access$getPopMenuRect$p(this.f222602a);
            if (r108 == null) goto L13;
            int r109 = (int) r108.right;
        L14:
            RectF r110 = DriveBubbleMenuPlugin.access$getPopMenuRect$p(this.f222602a);
            if (r110 == null) goto L17;
            r104 = (int) r110.bottom;
        L17:
            r102.set(r105, r107, r109, r104);
            return;
        L13:
            r109 = 0;
            goto L14
        L9:
            r107 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    private final boolean shouldSuppressMenu() {
        int r100 = this.keyboardHeight;
        if (r100 > 0) goto L5;
    L8:
        boolean r101 = false;
    L10:
        if (this.keyboardObserverRegistered == false) goto L14;
        if (r101 == false) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L5:
        if (this.hasHardKeyboard == false) goto L7;
        if (r100 == 1) goto L8;
    L7:
        r101 = true;
        goto L10
    }

    private final void startActionMode() {
        DrivePreviewContentPlugin r100 = (DrivePreviewContentPlugin) findPlugin(DrivePreviewContentPlugin.class);
        if (r100 == null) goto L12;
        AbsPreviewView r101 = r100.currentPreviewView();
        if (r101 == null) goto L12;
        View r102 = r101.getView();
        if (r102 == null) goto L12;
        int r103 = com.bytedance.ee.bear.drive.biz.bubblemenu.a.f222603a;
        e r104 = new e(this);
        Intrinsics.checkNotNullParameter(r102, "view");
        Intrinsics.checkNotNullParameter(r104, "callback");
        if (Build.VERSION.SDK_INT < 23) goto L11;
        ActionMode r105 = r102.startActionMode(new com.bytedance.ee.bear.drive.biz.bubblemenu.b(r104), 1);
        Intrinsics.checkNotNull(r105);
    L13:
        this.actionMode = r105;
        return;
    L11:
        r105 = r102.startActionMode(r104);
        Intrinsics.checkNotNull(r105);
    L12:
        r105 = null;
        goto L13
    }

    public DriveBubbleMenuPlugin() {
        this.keyboardHeightObserver = new b(this);
    }

    public static final /* synthetic */ ActionMode access$getActionMode$p(DriveBubbleMenuPlugin r100) {
        return r100.actionMode;
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DriveBubbleMenuPlugin r100) {
        return r100.getActivity();
    }

    public static final /* synthetic */ boolean access$getHasHardKeyboard$p(DriveBubbleMenuPlugin r100) {
        return r100.hasHardKeyboard;
    }

    public static final /* synthetic */ int access$getKeyboardHeight$p(DriveBubbleMenuPlugin r100) {
        return r100.keyboardHeight;
    }

    public static final /* synthetic */ List access$getMenuItems$p(DriveBubbleMenuPlugin r100) {
        return r100.menuItems;
    }

    public static final /* synthetic */ RectF access$getPopMenuRect$p(DriveBubbleMenuPlugin r100) {
        return r100.popMenuRect;
    }

    public static final /* synthetic */ boolean access$shouldSuppressMenu(DriveBubbleMenuPlugin r100) {
        return r100.shouldSuppressMenu();
    }

    public static final /* synthetic */ void access$startActionMode(DriveBubbleMenuPlugin r100) {
        r100.startActionMode();
    }

    private final void finishActionMode(String r100) {
        ActionMode r101 = this.actionMode;
        if (r101 == null) goto L6;
        tt5.a.h(TAG, "finishActionMode, reason=" + r100);
        r101.finish();
        this.actionMode = null;
        return;
    }

    private final boolean isKeyboardObserverEnabled(DrivePluginHost r100) {
        g r101 = r100.b().f2279c;
        boolean r102 = r101.isEnable("lark.switch_to_doubao.main");
        boolean r103 = r101.isEnable("ccm.ai.drive_aisidebar_doubao");
        tt5.a.h(TAG, "isKeyboardObserverEnabled, switchToDoubaoEnabled=" + r102 + ", driveAiSidebarEnabled=" + r103);
        if (r102 == false) goto L6;
        if (r103 == false) goto L6;
        return true;
    L6:
        return false;
    }

    private final void updateActionMode(ActionMode r100) {
        a r101 = Companion;
        Menu r102 = r100.getMenu();
        List<com.bytedance.ee.bear.drive.biz.bubblemenu.c> r103 = this.menuItems;
        r101.getClass();
        a.a(r102, r103);
        int r104 = com.bytedance.ee.bear.drive.biz.bubblemenu.a.f222603a;
        Intrinsics.checkNotNullParameter(r100, "actionMode");
        int r105 = Build.VERSION.SDK_INT;
        if (r105 < 23) goto L5;
        r100.invalidateContentRect();
    L6:
        Intrinsics.checkNotNullParameter(r100, "actionMode");
        if (r105 < 23) goto L10;
        r100.hide(300);
        return;
    L10:
        return;
    L5:
        r100.invalidate();
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        super.onAttachToHost(r100);
        this.keyboardObserverRegistered = isKeyboardObserverEnabled(r100);
        tt5.a.h(TAG, "onAttachToHost, keyboardObserverRegistered=" + this.keyboardObserverRegistered);
        if (this.keyboardObserverRegistered == false) goto L7;
        pcb.a r101 = pcb.a.AbstractC7181a.b(getActivity());
        this.keyboardHeightProvider = r101;
        this.keyboardHeight = r101.getVisibleKeyboardHeight();
        this.hasHardKeyboard = rcb.b.a(getActivity());
        tt5.a.h(TAG, "registerKeyboardObserver, initialKeyboardHeight=" + this.keyboardHeight + ", hasHardKeyboard=" + this.hasHardKeyboard);
        pcb.a r102 = this.keyboardHeightProvider;
        if (r102 == null) goto L7;
        r102.d(this.keyboardHeightObserver);
    L7:
        BubbleMenuVM r103 = (BubbleMenuVM) viewModel(BubbleMenuVM.class);
        this.bubbleMenuVM = r103;
        if (r103 == null) goto L12;
        LiveData<com.bytedance.ee.bear.drive.biz.bubblemenu.d> r104 = r103.getSelectionDataLiveData();
        if (r104 == null) goto L12;
        r104.observe(getLifecycleOwner(), new c(this));
    L12:
        BubbleMenuVM r105 = this.bubbleMenuVM;
        if (r105 == null) goto L18;
        LiveData<List<com.bytedance.ee.bear.drive.biz.bubblemenu.c>> r106 = r105.getMenuItemsLiveData();
        if (r106 == null) goto L19;
        r106.observe(r100.getLifecycleOwner(), new d(this));
        return;
    L19:
        return;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        StringBuilder r101 = new StringBuilder("onDetachFromHost, keyboardObserverRegistered=");
        r101.append(this.keyboardObserverRegistered);
        r101.append(", hasActionMode=");
        if (this.actionMode == null) goto L5;
        boolean r102 = true;
    L6:
        r101.append(r102);
        tt5.a.h(TAG, r101.toString());
        if (this.keyboardObserverRegistered == false) goto L11;
        pcb.a r103 = this.keyboardHeightProvider;
        if (r103 == null) goto L11;
        r103.b(this.keyboardHeightObserver);
    L11:
        this.keyboardHeightProvider = null;
        this.keyboardObserverRegistered = false;
        this.keyboardHeight = 0;
        this.hasHardKeyboard = false;
        finishActionMode("detach_from_host");
        this.bubbleMenuVM = null;
        this.menuItems = null;
        this.popMenuRect = null;
        super.onDetachFromHost(r100);
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((DrivePluginHost) r100);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r100) {
        onDetachFromHost((DrivePluginHost) r100);
    }

    public static final /* synthetic */ void access$finishActionMode(DriveBubbleMenuPlugin r100, String r101) {
        r100.finishActionMode(r101);
    }

    public static final /* synthetic */ void access$setHasHardKeyboard$p(DriveBubbleMenuPlugin r100, boolean r101) {
        r100.hasHardKeyboard = r101;
    }

    public static final /* synthetic */ void access$setKeyboardHeight$p(DriveBubbleMenuPlugin r100, int r101) {
        r100.keyboardHeight = r101;
    }

    public static final /* synthetic */ void access$setMenuItems$p(DriveBubbleMenuPlugin r100, List r101) {
        r100.menuItems = r101;
    }

    public static final /* synthetic */ void access$setPopMenuRect$p(DriveBubbleMenuPlugin r100, RectF r101) {
        r100.popMenuRect = r101;
    }

    public static final /* synthetic */ void access$updateActionMode(DriveBubbleMenuPlugin r100, ActionMode r101) {
        r100.updateActionMode(r101);
    }
}
