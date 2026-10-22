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
import java.util.Iterator;
import java.util.List;
import jdb.g;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

        public static void a(Menu r4, List r5) {
            Intrinsics.checkNotNullParameter(r4, "menu");
            r4.removeGroup(DriveBubbleMenuPlugin.DRIVE_BUBBLE_MENU_GROUP_ID);
            if (r5 != null) goto L5;
            r5 = CollectionsKt.emptyList();
        L5:
            Iterator r6 = r5.iterator();
        L7:
            if (r6.hasNext() == false) goto L11;
            com.bytedance.ee.bear.drive.biz.bubblemenu.c r1 = (com.bytedance.ee.bear.drive.biz.bubblemenu.c) r6.next();
            if (((Boolean) r1.d.invoke(r1.a)).booleanValue() == false) goto L7;
            r4.add(DriveBubbleMenuPlugin.DRIVE_BUBBLE_MENU_GROUP_ID, r1.a.hashCode(), r1.c, r1.b);
            goto L7
        }
    }

    public static final class b implements ocb.a {
        public final /* synthetic */ DriveBubbleMenuPlugin a;

        public b(DriveBubbleMenuPlugin r1) {
            this.a = r1;
        }

        public final void onKeyboardHeightChanged(pcb.a r2, int r3, int r4) {
            boolean r5 = DriveBubbleMenuPlugin.access$shouldSuppressMenu(this.a);
            DriveBubbleMenuPlugin.access$setKeyboardHeight$p(this.a, r3);
            DriveBubbleMenuPlugin r6 = this.a;
            DriveBubbleMenuPlugin.access$setHasHardKeyboard$p(r6, rcb.b.a(DriveBubbleMenuPlugin.access$getActivity(r6)));
            boolean r7 = DriveBubbleMenuPlugin.access$shouldSuppressMenu(this.a);
            if (r5 == r7) goto L10;
            StringBuilder r8 = new StringBuilder("onKeyboardVisibilityChanged, isShowing=");
            r8.append(r7);
            r8.append(", height=");
            r8.append(DriveBubbleMenuPlugin.access$getKeyboardHeight$p(this.a));
            r8.append(", hasHardKeyboard=");
            r8.append(DriveBubbleMenuPlugin.access$getHasHardKeyboard$p(this.a));
            r8.append(", orientation=");
            r8.append(r4);
            r8.append(", hasActionMode=");
            if (DriveBubbleMenuPlugin.access$getActionMode$p(this.a) == null) goto L7;
            boolean r9 = true;
        L8:
            r8.append(r9);
            tt5.a.h(DriveBubbleMenuPlugin.TAG, r8.toString());
            goto L10
        L7:
            r9 = false;
        L10:
            if (DriveBubbleMenuPlugin.access$shouldSuppressMenu(this.a) == false) goto L13;
            DriveBubbleMenuPlugin.access$finishActionMode(this.a, "keyboard_shown");
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ DriveBubbleMenuPlugin a;

        public c(DriveBubbleMenuPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            com.bytedance.ee.bear.drive.biz.bubblemenu.d r6 = (com.bytedance.ee.bear.drive.biz.bubblemenu.d) r5;
            tt5.a.h(DriveBubbleMenuPlugin.TAG, "onSelectionChanged, " + r6);
            StringBuilder r0 = new StringBuilder();
            if (r6 == null) goto L13;
            List<TTReaderSelectionInfo> r1 = r6.a;
            if (r1 == null) goto L13;
            Iterator<T> r2 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L13;
            String r3 = ((TTReaderSelectionInfo) r2.next()).selectedText;
            if (r3 != null) goto L12;
            r3 = "";
        L12:
            r0.append(r3);
        L13:
            String r4 = r0.toString();
            RectF r7 = null;
            if (r6 == null) goto L18;
            Bundle r8 = r6.b;
            if (r8 == null) goto L18;
            RectF r9 = (RectF) r8.getParcelable("selectionRect");
        L20:
            if ((r9 instanceof RectF) == false) goto L22;
            r7 = r9;
        L22:
            if (r7 != null) goto L24;
            r7 = new RectF();
        L24:
            if (r6 != null) goto L26;
        L37:
            DriveBubbleMenuPlugin.access$finishActionMode(this.a, "invalid_selection");
            return;
        L26:
            if (r4.length() != 0) goto L28;
            boolean r10 = true;
        L29:
            if (r10 == true) goto L37;
            if (r7.isEmpty() == true) goto L37;
            DriveBubbleMenuPlugin.access$setPopMenuRect$p(this.a, r7);
            ActionMode r11 = DriveBubbleMenuPlugin.access$getActionMode$p(this.a);
            if (r11 == null) goto L36;
            DriveBubbleMenuPlugin.access$updateActionMode(this.a, r11);
            return;
        L36:
            DriveBubbleMenuPlugin.access$startActionMode(this.a);
            return;
        L28:
            r10 = false;
        L18:
            r9 = null;
            goto L20
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ DriveBubbleMenuPlugin a;

        public d(DriveBubbleMenuPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            DriveBubbleMenuPlugin r0 = this.a;
            DriveBubbleMenuPlugin.access$setMenuItems$p(r0, (List) r2);
            ActionMode r3 = DriveBubbleMenuPlugin.access$getActionMode$p(this.a);
            if (r3 == null) goto L6;
            r3.invalidate();
            return;
        }
    }

    public static final class e implements com.bytedance.ee.bear.drive.biz.bubblemenu.a.InterfaceActionModeCallbackC0117a {
        public final /* synthetic */ DriveBubbleMenuPlugin a;

        public e(DriveBubbleMenuPlugin r1) {
            this.a = r1;
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode r2) {
            Intrinsics.checkNotNullParameter(r2, "actionMode");
            tt5.a.h(DriveBubbleMenuPlugin.TAG, "onDestroyActionMode");
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode r4, MenuItem r5) {
            Intrinsics.checkNotNullParameter(r4, "actionMode");
            Intrinsics.checkNotNullParameter(r5, "menuItem");
            tt5.a.h(DriveBubbleMenuPlugin.TAG, "onActionItemClicked");
            List r6 = DriveBubbleMenuPlugin.access$getMenuItems$p(this.a);
            if (r6 == null) goto L14;
            Iterator r7 = r6.iterator();
        L6:
            if (r7.hasNext() == false) goto L10;
            Object r0 = r7.next();
            if (Intrinsics.areEqual(((com.bytedance.ee.bear.drive.biz.bubblemenu.c) r0).b, r5.getTitle()) == false) goto L6;
        L11:
            com.bytedance.ee.bear.drive.biz.bubblemenu.c r1 = (com.bytedance.ee.bear.drive.biz.bubblemenu.c) r0;
            if (r1 == null) goto L14;
            r1.e.invoke(r1.a);
            goto L14
        L10:
            r0 = null;
        L14:
            DriveBubbleMenuPlugin.access$finishActionMode(this.a, "menu_item_clicked");
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode r2, Menu r3) {
            Intrinsics.checkNotNullParameter(r2, "actionMode");
            Intrinsics.checkNotNullParameter(r3, "menu");
            tt5.a.h(DriveBubbleMenuPlugin.TAG, "onCreateActionMode");
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode r2, Menu r3) {
            Intrinsics.checkNotNullParameter(r2, "actionMode");
            Intrinsics.checkNotNullParameter(r3, "menu");
            a r4 = DriveBubbleMenuPlugin.Companion;
            List r0 = DriveBubbleMenuPlugin.access$getMenuItems$p(this.a);
            r4.getClass();
            a.a(r3, r0);
            tt5.a.h(DriveBubbleMenuPlugin.TAG, "onPrepareActionMode");
            return true;
        }

        @Override // com.bytedance.ee.bear.drive.biz.bubblemenu.a.InterfaceActionModeCallbackC0117a
        public final void onGetContentRect(ActionMode r4, View r5, Rect r6) {
            Intrinsics.checkNotNullParameter(r4, "mode");
            Intrinsics.checkNotNullParameter(r5, "view");
            Intrinsics.checkNotNullParameter(r6, "outRect");
            RectF r7 = DriveBubbleMenuPlugin.access$getPopMenuRect$p(this.a);
            int r8 = 0;
            if (r7 == null) goto L5;
            int r9 = (int) r7.left;
        L6:
            RectF r0 = DriveBubbleMenuPlugin.access$getPopMenuRect$p(this.a);
            if (r0 == null) goto L9;
            int r1 = (int) r0.top;
        L10:
            RectF r2 = DriveBubbleMenuPlugin.access$getPopMenuRect$p(this.a);
            if (r2 == null) goto L13;
            int r3 = (int) r2.right;
        L14:
            RectF r10 = DriveBubbleMenuPlugin.access$getPopMenuRect$p(this.a);
            if (r10 == null) goto L17;
            r8 = (int) r10.bottom;
        L17:
            r6.set(r9, r1, r3, r8);
            return;
        L13:
            r3 = 0;
            goto L14
        L9:
            r1 = 0;
            goto L10
        L5:
            r9 = 0;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final boolean shouldSuppressMenu() {
        int r0 = this.keyboardHeight;
        if (r0 > 0) goto L5;
    L8:
        boolean r1 = false;
    L10:
        if (this.keyboardObserverRegistered == false) goto L14;
        if (r1 == false) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L5:
        if (this.hasHardKeyboard == false) goto L7;
        if (r0 == 1) goto L8;
    L7:
        r1 = true;
        goto L10
    }

    private final void startActionMode() {
        DrivePreviewContentPlugin r0 = (DrivePreviewContentPlugin) findPlugin(DrivePreviewContentPlugin.class);
        if (r0 == null) goto L12;
        AbsPreviewView r1 = r0.currentPreviewView();
        if (r1 == null) goto L12;
        View r2 = r1.getView();
        if (r2 == null) goto L12;
        int r3 = com.bytedance.ee.bear.drive.biz.bubblemenu.a.a;
        e r4 = new e(this);
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r4, "callback");
        if (Build.VERSION.SDK_INT < 23) goto L11;
        ActionMode r5 = r2.startActionMode(new com.bytedance.ee.bear.drive.biz.bubblemenu.b(r4), 1);
        Intrinsics.checkNotNull(r5);
    L13:
        this.actionMode = r5;
        return;
    L11:
        r5 = r2.startActionMode(r4);
        Intrinsics.checkNotNull(r5);
    L12:
        r5 = null;
        goto L13
    }

    public DriveBubbleMenuPlugin() {
        this.keyboardHeightObserver = new b(this);
    }

    public static final /* synthetic */ ActionMode access$getActionMode$p(DriveBubbleMenuPlugin r0) {
        return r0.actionMode;
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DriveBubbleMenuPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ boolean access$getHasHardKeyboard$p(DriveBubbleMenuPlugin r0) {
        return r0.hasHardKeyboard;
    }

    public static final /* synthetic */ int access$getKeyboardHeight$p(DriveBubbleMenuPlugin r0) {
        return r0.keyboardHeight;
    }

    public static final /* synthetic */ List access$getMenuItems$p(DriveBubbleMenuPlugin r0) {
        return r0.menuItems;
    }

    public static final /* synthetic */ RectF access$getPopMenuRect$p(DriveBubbleMenuPlugin r0) {
        return r0.popMenuRect;
    }

    public static final /* synthetic */ boolean access$shouldSuppressMenu(DriveBubbleMenuPlugin r0) {
        return r0.shouldSuppressMenu();
    }

    public static final /* synthetic */ void access$startActionMode(DriveBubbleMenuPlugin r0) {
        r0.startActionMode();
    }

    private final void finishActionMode(String r4) {
        ActionMode r0 = this.actionMode;
        if (r0 == null) goto L6;
        tt5.a.h(TAG, "finishActionMode, reason=" + r4);
        r0.finish();
        this.actionMode = null;
        return;
    }

    private final boolean isKeyboardObserverEnabled(DrivePluginHost r4) {
        g r5 = r4.b().c;
        boolean r0 = r5.isEnable("lark.switch_to_doubao.main");
        boolean r6 = r5.isEnable("ccm.ai.drive_aisidebar_doubao");
        tt5.a.h(TAG, "isKeyboardObserverEnabled, switchToDoubaoEnabled=" + r0 + ", driveAiSidebarEnabled=" + r6);
        if (r0 == false) goto L6;
        if (r6 == false) goto L6;
        return true;
    L6:
        return false;
    }

    private final void updateActionMode(ActionMode r4) {
        a r0 = Companion;
        Menu r1 = r4.getMenu();
        List<com.bytedance.ee.bear.drive.biz.bubblemenu.c> r2 = this.menuItems;
        r0.getClass();
        a.a(r1, r2);
        int r3 = com.bytedance.ee.bear.drive.biz.bubblemenu.a.a;
        Intrinsics.checkNotNullParameter(r4, "actionMode");
        int r5 = Build.VERSION.SDK_INT;
        if (r5 < 23) goto L5;
        r4.invalidateContentRect();
    L6:
        Intrinsics.checkNotNullParameter(r4, "actionMode");
        if (r5 < 23) goto L10;
        r4.hide(MENU_HIDE_DURATION);
        return;
    L10:
        return;
    L5:
        r4.invalidate();
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        this.keyboardObserverRegistered = isKeyboardObserverEnabled(r4);
        tt5.a.h(TAG, "onAttachToHost, keyboardObserverRegistered=" + this.keyboardObserverRegistered);
        if (this.keyboardObserverRegistered == false) goto L7;
        pcb.a r0 = pcb.a.a.b(getActivity());
        this.keyboardHeightProvider = r0;
        this.keyboardHeight = r0.getVisibleKeyboardHeight();
        this.hasHardKeyboard = rcb.b.a(getActivity());
        tt5.a.h(TAG, "registerKeyboardObserver, initialKeyboardHeight=" + this.keyboardHeight + ", hasHardKeyboard=" + this.hasHardKeyboard);
        pcb.a r1 = this.keyboardHeightProvider;
        if (r1 == null) goto L7;
        r1.d(this.keyboardHeightObserver);
    L7:
        BubbleMenuVM r2 = (BubbleMenuVM) viewModel(BubbleMenuVM.class);
        this.bubbleMenuVM = r2;
        if (r2 == null) goto L12;
        LiveData<com.bytedance.ee.bear.drive.biz.bubblemenu.d> r3 = r2.getSelectionDataLiveData();
        if (r3 == null) goto L12;
        r3.observe(getLifecycleOwner(), new c(this));
    L12:
        BubbleMenuVM r5 = this.bubbleMenuVM;
        if (r5 == null) goto L18;
        LiveData<List<com.bytedance.ee.bear.drive.biz.bubblemenu.c>> r6 = r5.getMenuItemsLiveData();
        if (r6 == null) goto L19;
        r6.observe(r4.getLifecycleOwner(), new d(this));
        return;
    L19:
        return;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        StringBuilder r0 = new StringBuilder("onDetachFromHost, keyboardObserverRegistered=");
        r0.append(this.keyboardObserverRegistered);
        r0.append(", hasActionMode=");
        if (this.actionMode == null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        tt5.a.h(TAG, r0.toString());
        if (this.keyboardObserverRegistered == false) goto L11;
        pcb.a r2 = this.keyboardHeightProvider;
        if (r2 == null) goto L11;
        r2.b(this.keyboardHeightObserver);
    L11:
        this.keyboardHeightProvider = null;
        this.keyboardObserverRegistered = false;
        this.keyboardHeight = 0;
        this.hasHardKeyboard = false;
        finishActionMode("detach_from_host");
        this.bubbleMenuVM = null;
        this.menuItems = null;
        this.popMenuRect = null;
        super.onDetachFromHost(r4);
        return;
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ void access$finishActionMode(DriveBubbleMenuPlugin r0, String r1) {
        r0.finishActionMode(r1);
    }

    public static final /* synthetic */ void access$setHasHardKeyboard$p(DriveBubbleMenuPlugin r0, boolean r1) {
        r0.hasHardKeyboard = r1;
    }

    public static final /* synthetic */ void access$setKeyboardHeight$p(DriveBubbleMenuPlugin r0, int r1) {
        r0.keyboardHeight = r1;
    }

    public static final /* synthetic */ void access$setMenuItems$p(DriveBubbleMenuPlugin r0, List r1) {
        r0.menuItems = r1;
    }

    public static final /* synthetic */ void access$setPopMenuRect$p(DriveBubbleMenuPlugin r0, RectF r1) {
        r0.popMenuRect = r1;
    }

    public static final /* synthetic */ void access$updateActionMode(DriveBubbleMenuPlugin r0, ActionMode r1) {
        r0.updateActionMode(r1);
    }
}
