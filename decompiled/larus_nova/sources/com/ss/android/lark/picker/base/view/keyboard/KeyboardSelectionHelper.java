package com.ss.android.lark.picker.base.view.keyboard;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.ss.android.lark.log.Log;
import com.suite.lark.emm.autofocus.AutoFocusEditText;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB+\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0012H\u0002J\u0006\u0010\u001c\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/picker/base/view/keyboard/KeyboardSelectionHelper;", "Lcom/suite/lark/emm/autofocus/AutoFocusEditText$KeyboardSelectionDependency;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/ss/android/lark/picker/base/view/keyboard/KeyboardSelectionAdapter;", "editText", "Lcom/suite/lark/emm/autofocus/AutoFocusEditText;", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/ss/android/lark/picker/base/view/keyboard/KeyboardSelectionAdapter;Lcom/suite/lark/emm/autofocus/AutoFocusEditText;)V", "editTextRef", "Ljava/lang/ref/WeakReference;", "value", "getEditText", "()Lcom/suite/lark/emm/autofocus/AutoFocusEditText;", "setEditText", "(Lcom/suite/lark/emm/autofocus/AutoFocusEditText;)V", "onNext", "", "onPrev", "onSelect", "setupKeyboardNavigation", BasicTestActionHandler.TEST_ACTION_RESET, "", "handleScroll", "delta", "", "triggerItemClick", "cleanup", "Companion", "GlobalKeyboardDispatcher", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardSelectionHelper implements AutoFocusEditText.b {
    public static final Companion Companion = null;
    private static final int DEFAULT_VISIBLE_THRESHOLD = 1;
    private static final String TAG = "KeyboardSelectionHelper";
    private static WeakReference<AutoFocusEditText> currentActiveEditText;
    private static WeakReference<KeyboardSelectionHelper> currentActiveHelper;
    private static GlobalKeyboardDispatcher globalKeyboardDispatcher;
    private final KeyboardSelectionAdapter<?, ?> adapter;
    private WeakReference<AutoFocusEditText> editTextRef;
    private RecyclerView recyclerView;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0007J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\fH\u0002J\b\u0010\u0018\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/picker/base/view/keyboard/KeyboardSelectionHelper$Companion;", "", "<init>", "()V", "TAG", "", "DEFAULT_VISIBLE_THRESHOLD", "", "currentActiveHelper", "Ljava/lang/ref/WeakReference;", "Lcom/ss/android/lark/picker/base/view/keyboard/KeyboardSelectionHelper;", "currentActiveEditText", "Lcom/suite/lark/emm/autofocus/AutoFocusEditText;", "globalKeyboardDispatcher", "Lcom/ss/android/lark/picker/base/view/keyboard/KeyboardSelectionHelper$GlobalKeyboardDispatcher;", "getInstance", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/ss/android/lark/picker/base/view/keyboard/KeyboardSelectionAdapter;", "editText", "setActiveHelper", "", "helper", "getCurrentActiveHelper", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final KeyboardSelectionHelper getCurrentActiveHelper() {
            WeakReference r100 = KeyboardSelectionHelper.access$getCurrentActiveHelper$cp();
            if (r100 != null) goto L7;
            return null;
        L7:
            return (KeyboardSelectionHelper) r100.get();
        }

        private final void setActiveHelper(KeyboardSelectionHelper r100, AutoFocusEditText r101) {
            WeakReference r102 = KeyboardSelectionHelper.access$getCurrentActiveEditText$cp();
            if (r102 == null) goto L5;
            AutoFocusEditText r103 = (AutoFocusEditText) r102.get();
        L6:
            WeakReference r104 = KeyboardSelectionHelper.access$getCurrentActiveHelper$cp();
            if (r104 == null) goto L10;
            KeyboardSelectionHelper r105 = (KeyboardSelectionHelper) r104.get();
        L10:
            if (r103 == null) goto L13;
            if (r103 == r101) goto L13;
            KeyboardSelectionHelperKt.disableKeyboardSelection(r103);
            Log.d(KeyboardSelectionHelper.TAG, "disable previous KeyboardSelection");
        L13:
            KeyboardSelectionHelper.access$setCurrentActiveHelper$cp(new WeakReference(r100));
            KeyboardSelectionHelper.access$setCurrentActiveEditText$cp(new WeakReference(r101));
            if (r103 == r101) goto L16;
            KeyboardSelectionHelper.access$setGlobalKeyboardDispatcher$cp(new GlobalKeyboardDispatcher());
            r101.a(KeyboardSelectionHelper.access$getGlobalKeyboardDispatcher$cp());
            Log.d(KeyboardSelectionHelper.TAG, "enable new KeyboardSelection");
        L16:
            Log.d(KeyboardSelectionHelper.TAG, "KeyboardSelection is update");
            return;
        L5:
            r103 = null;
            goto L6
        }

        public static final /* synthetic */ void access$setActiveHelper(Companion r100, KeyboardSelectionHelper r101, AutoFocusEditText r102) {
            r100.setActiveHelper(r101, r102);
        }

        @JvmStatic
        public final KeyboardSelectionHelper getInstance(RecyclerView r100, KeyboardSelectionAdapter<?, ?> r101, AutoFocusEditText r102) {
            Intrinsics.checkNotNullParameter(r100, "recyclerView");
            Intrinsics.checkNotNullParameter(r101, "adapter");
            KeyboardSelectionHelper r103 = r101.getHelper();
            if (r103 == null) goto L10;
            Log.d(KeyboardSelectionHelper.TAG, "get existing helper");
            if (Intrinsics.areEqual(r103.getEditText(), r102) == true) goto L7;
            r103.setEditText(r102);
            r103.setupKeyboardNavigation(false);
        L7:
            if (r102 == null) goto L9;
            setActiveHelper(r103, r102);
            Log.d(KeyboardSelectionHelper.TAG, "existing helper active");
        L9:
            return r103;
        L10:
            Log.d(KeyboardSelectionHelper.TAG, "create new helper");
            KeyboardSelectionHelper r104 = new KeyboardSelectionHelper(r100, r101, r102, null);
            r101.setHelper(r104);
            if (r102 == null) goto L13;
            Log.d(KeyboardSelectionHelper.TAG, "new helper active");
            KeyboardSelectionHelper.Companion.setActiveHelper(r104, r102);
        L13:
            return r104;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/base/view/keyboard/KeyboardSelectionHelper$GlobalKeyboardDispatcher;", "Lcom/suite/lark/emm/autofocus/AutoFocusEditText$KeyboardSelectionDependency;", "<init>", "()V", "onNext", "", "onPrev", "onSelect", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GlobalKeyboardDispatcher implements AutoFocusEditText.b {
        public GlobalKeyboardDispatcher() {
        }

        @Override // com.suite.lark.emm.autofocus.AutoFocusEditText.b
        public void onNext() {
            KeyboardSelectionHelper r100 = KeyboardSelectionHelper.Companion.getCurrentActiveHelper();
            if (r100 == null) goto L6;
            r100.onNext();
            return;
        }

        @Override // com.suite.lark.emm.autofocus.AutoFocusEditText.b
        public void onPrev() {
            KeyboardSelectionHelper r100 = KeyboardSelectionHelper.Companion.getCurrentActiveHelper();
            if (r100 == null) goto L6;
            r100.onPrev();
            return;
        }

        @Override // com.suite.lark.emm.autofocus.AutoFocusEditText.b
        public void onSelect() {
            KeyboardSelectionHelper r100 = KeyboardSelectionHelper.Companion.getCurrentActiveHelper();
            if (r100 == null) goto L6;
            r100.onSelect();
            return;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ KeyboardSelectionHelper(RecyclerView r100, KeyboardSelectionAdapter r101, AutoFocusEditText r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    @JvmStatic
    public static final KeyboardSelectionHelper getInstance(RecyclerView r100, KeyboardSelectionAdapter<?, ?> r101, AutoFocusEditText r102) {
        return Companion.getInstance(r100, r101, r102);
    }

    @Override // com.suite.lark.emm.autofocus.AutoFocusEditText.b
    public void onNext() {
        handleScroll(1);
    }

    @Override // com.suite.lark.emm.autofocus.AutoFocusEditText.b
    public void onPrev() {
        handleScroll(-1);
    }

    private final void triggerItemClick() {
        Log.i(TAG, "handleKeyEvent : triggerItemClick");
        int r100 = this.adapter.getSelectedPosition();
        if (r100 >= 0) goto L5;
        return;
    L5:
        if (r100 >= this.adapter.getItemCount()) goto L16;
        RecyclerView.ViewHolder r101 = this.recyclerView.findViewHolderForAdapterPosition(r100);
        if (r101 == null) goto L10;
        View r102 = r101.itemView;
    L11:
        if (r102 == null) goto L15;
        r102.performClick();
        return;
    L15:
        return;
    L10:
        r102 = null;
        goto L11
    }

    public final void cleanup() {
        WeakReference<KeyboardSelectionHelper> r100 = currentActiveHelper;
        if (r100 == null) goto L5;
        KeyboardSelectionHelper r101 = r100.get();
    L6:
        if (r101 != this) goto L13;
        WeakReference<AutoFocusEditText> r102 = currentActiveEditText;
        if (r102 == null) goto L12;
        AutoFocusEditText r103 = r102.get();
        if (r103 == null) goto L12;
        KeyboardSelectionHelperKt.disableKeyboardSelection(r103);
    L12:
        currentActiveHelper = null;
        currentActiveEditText = null;
        globalKeyboardDispatcher = null;
    L13:
        setEditText(null);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final AutoFocusEditText getEditText() {
        return this.editTextRef.get();
    }

    public static final /* synthetic */ WeakReference access$getCurrentActiveEditText$cp() {
        return currentActiveEditText;
    }

    public static final /* synthetic */ WeakReference access$getCurrentActiveHelper$cp() {
        return currentActiveHelper;
    }

    public static final /* synthetic */ GlobalKeyboardDispatcher access$getGlobalKeyboardDispatcher$cp() {
        return globalKeyboardDispatcher;
    }

    @Override // com.suite.lark.emm.autofocus.AutoFocusEditText.b
    public void onSelect() {
        triggerItemClick();
    }

    public static final /* synthetic */ void access$setCurrentActiveEditText$cp(WeakReference r100) {
        currentActiveEditText = r100;
    }

    public static final /* synthetic */ void access$setCurrentActiveHelper$cp(WeakReference r100) {
        currentActiveHelper = r100;
    }

    public static final /* synthetic */ void access$setGlobalKeyboardDispatcher$cp(GlobalKeyboardDispatcher r100) {
        globalKeyboardDispatcher = r100;
    }

    private final void handleScroll(int r100) {
        this.adapter.updateSelectedState(r100);
        RecyclerView.LayoutManager r101 = this.recyclerView.getLayoutManager();
        if ((r101 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r102 = (LinearLayoutManager) r101;
    L6:
        if (r102 == null) goto L25;
        int r103 = r102.findFirstVisibleItemPosition();
        int r104 = r102.findLastVisibleItemPosition();
        Log.d("KeyboardNav", "Visible threshold set to: 1");
        if (this.adapter.getSelectedPosition() > r103) goto L12;
        Log.d("KeyboardNav", "Case: Before first visible");
    L10:
        boolean r105 = true;
    L15:
        if (r105 == true) goto L17;
        this.recyclerView.smoothScrollToPosition(this.adapter.getSelectedPosition());
        return;
    L17:
        if (r100 == (-1)) goto L21;
        if (r100 == 1) goto L20;
        int r106 = this.adapter.getSelectedPosition();
    L22:
        Log.d("KeyboardNav", "Adjusting to target position: " + r106);
        this.recyclerView.smoothScrollToPosition(r106);
        return;
    L20:
        r106 = Math.max(0, this.adapter.getSelectedPosition() + 1);
        goto L22
    L21:
        r106 = Math.max(0, this.adapter.getSelectedPosition() - 1);
        goto L22
    L12:
        if (this.adapter.getSelectedPosition() <= (r104 - 1)) goto L14;
        Log.d("KeyboardNav", "Case: At/After threshold position");
        goto L10
    L14:
        Log.d("KeyboardNav", "Case: Within safe zone");
        r105 = false;
        goto L15
    L25:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void setEditText(AutoFocusEditText r100) {
        this.editTextRef = new WeakReference(r100);
    }

    public final void setupKeyboardNavigation(boolean r100) {
        AutoFocusEditText r101 = getEditText();
        if (r101 == null) goto L5;
        Companion.access$setActiveHelper(Companion, this, r101);
    L5:
        if (r100 == false) goto L8;
        this.adapter.resetSelectPosition();
        return;
    }

    private KeyboardSelectionHelper(RecyclerView r100, KeyboardSelectionAdapter<?, ?> r101, AutoFocusEditText r102) {
        this.recyclerView = r100;
        this.adapter = r101;
        this.editTextRef = new WeakReference(r102);
        setupKeyboardNavigation(true);
    }
}
