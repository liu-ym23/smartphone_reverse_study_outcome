package com.ss.android.lark.todo.impl.features.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.framework.section.h;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.TodoDetailModel;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.TodoAttachmentData;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.p;
import com.ss.android.lark.todo.impl.features.detail.widget.KeyboardScrollView;
import com.ss.android.lark.todo.impl.utils.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 L2\u00020\u00012\u00020\u0002:\u0002KLB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020$H\u0016J&\u0010)\u001a\u0004\u0018\u00010\u00182\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u001a\u00100\u001a\u00020$2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020402J\b\u00105\u001a\u00020$H\u0002J\u0010\u00106\u001a\u00020$2\u0006\u00107\u001a\u00020'H\u0016J\b\u00108\u001a\u00020$H\u0016J\u0006\u00109\u001a\u00020:J\u001c\u0010<\u001a\u00020$2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020402H\u0016J\b\u0010>\u001a\u00020$H\u0002J\b\u0010I\u001a\u00020$H\u0016J\b\u0010J\u001a\u00020$H\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00188FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001e8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010;\u001a\u0010\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u000204\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010?\u001a\u00020'X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010C\u001a\u00020DX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H¨\u0006M"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/TodoKeyboardFragment;", "Lcom/ss/android/lark/todo/impl/features/detail/DetailBaseFragment;", "Lcom/ss/android/lark/todo/impl/features/detail/IMVInitiator;", "<init>", "()V", "buttonCreateFromXml", "Lcom/larksuite/component/universe_design/button/UDButton;", "getButtonCreateFromXml", "()Lcom/larksuite/component/universe_design/button/UDButton;", "setButtonCreateFromXml", "(Lcom/larksuite/component/universe_design/button/UDButton;)V", "inputExpandFromXml", "Landroid/widget/ImageView;", "getInputExpandFromXml", "()Landroid/widget/ImageView;", "setInputExpandFromXml", "(Landroid/widget/ImageView;)V", "selectedConditionListFromXml", "Lcom/ss/android/lark/todo/impl/features/detail/widget/KeyboardScrollView;", "getSelectedConditionListFromXml", "()Lcom/ss/android/lark/todo/impl/features/detail/widget/KeyboardScrollView;", "setSelectedConditionListFromXml", "(Lcom/ss/android/lark/todo/impl/features/detail/widget/KeyboardScrollView;)V", "shaderFromXml", "Landroid/view/View;", "getShaderFromXml", "()Landroid/view/View;", "setShaderFromXml", "(Landroid/view/View;)V", "inputContentFromXml", "Lcom/ss/android/lark/keyboard/edittext2/KeyboardFunctionEditText;", "getInputContentFromXml", "()Lcom/ss/android/lark/keyboard/edittext2/KeyboardFunctionEditText;", "setInputContentFromXml", "(Lcom/ss/android/lark/keyboard/edittext2/KeyboardFunctionEditText;)V", "clearFromXmlViewCache", "", "onDestroyView", "createFromActionNext", "", "isFragVisible", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setViewModel", "sectionMgr", "Lcom/larksuite/framework/section/SectionManager;", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/ITodoDetailViewDataStore;", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/TodoDetailModel;", "initView", "onFragVisibilityChange", "isVisible", "onResume", "getToastY", "", "sectionManager", "initMVComposer", "summaryLength", "displayCreateButton", "isAddToActivity", "()Z", "setAddToActivity", "(Z)V", "finishCallback", "Lcom/ss/android/lark/todo/impl/features/detail/DetailBaseFragment$FinishCallBack;", "getFinishCallback", "()Lcom/ss/android/lark/todo/impl/features/detail/DetailBaseFragment$FinishCallBack;", "setFinishCallback", "(Lcom/ss/android/lark/todo/impl/features/detail/DetailBaseFragment$FinishCallBack;)V", "refreshPage", "syncData", "ActionManager", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TodoKeyboardFragment extends DetailBaseFragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public UDButton f442551h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f442552i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public KeyboardScrollView f442553j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f442554k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f442555l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.larksuite.framework.section.g<p, TodoDetailModel> f442556m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f442557n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f442558o;

    public final class ActionManager extends h<p> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TodoKeyboardFragment f442559b;

        @Override // com.larksuite.framework.section.h
        public final void i() {
        }

        @Override // com.larksuite.framework.section.h
        public final void j() {
            p r100 = e();
            final TodoKeyboardFragment r101 = this.f442559b;
            p r102 = r100;
            k(r102.getFastCreateInitData(), new TodoKeyboardFragment$ActionManager$initViewObserver$1$1(r101));
            k(r102.getFastCreateExpandEvent(), new TodoKeyboardFragment$ActionManager$initViewObserver$1$2(r101));
            k(r102.getAttachments(), new TodoKeyboardFragment$ActionManager$initViewObserver$1$3(r101));
        }

        public ActionManager(TodoKeyboardFragment r100, com.larksuite.framework.section.e<p> r101) {
            Intrinsics.checkNotNullParameter(r101, "viewAbility");
            this.f442559b = r100;
            super(r101);
        }

        @Override // com.larksuite.framework.section.h
        public final void g(com.ss.android.lark.todo.impl.features.detail.viewmodel.a r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "action");
            if (Intrinsics.areEqual(r100, com.ss.android.lark.todo.impl.features.detail.viewmodel.a.j3.f443720a) == false) goto L6;
            TodoKeyboardFragment r102 = this.f442559b;
            r102.f442557n = r101;
            TodoKeyboardFragment.ba0(r102);
            return;
        }
    }

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/TodoKeyboardFragment$Companion$State;", "", "<init>", "(Ljava/lang/String;I)V", "CreateSuccess", "DeleteSuccess", "Unknown", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum State extends Enum<State> {
            public static final State CreateSuccess = null;
            public static final State DeleteSuccess = null;
            public static final State Unknown = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ State[] f442561a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f442562b = null;

            public static EnumEntries<State> getEntries() {
                return f442562b;
            }

            static {
                State r100 = new State("CreateSuccess", 0);
                CreateSuccess = r100;
                State r101 = new State("DeleteSuccess", 1);
                DeleteSuccess = r101;
                State r102 = new State("Unknown", 2);
                Unknown = r102;
                State[] r103 = {r100, r101, r102};
                f442561a = r103;
                f442562b = EnumEntriesKt.enumEntries(r103);
            }

            public static State[] values() {
                return (State[]) f442561a.clone();
            }

            public static State valueOf(String r100) {
                return (State) r27.a.a(State.class, r100);
            }

            public State(String r100, int r101) {
                super(r100, r101);
            }
        }
    }

    static {
    }

    @Override // com.ss.android.lark.todo.impl.features.detail.DetailBaseFragment
    public final void Z90() {
        this.f442558o = true;
    }

    @Override // com.ss.android.lark.todo.impl.features.detail.DetailBaseFragment
    public final void Y90() {
        com.larksuite.framework.section.g<p, TodoDetailModel> r100 = this.f442556m;
        if (r100 == null) goto L8;
        com.larksuite.framework.section.c r101 = r100.c();
        if (r101 == null) goto L9;
        r101.a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.e3.f443690a);
        return;
    L9:
        return;
    }

    @Override // com.ss.android.lark.todo.impl.features.detail.DetailBaseFragment
    public final void aa0() {
        com.larksuite.framework.section.g<p, TodoDetailModel> r100 = this.f442556m;
        if (r100 == null) goto L8;
        com.larksuite.framework.section.c r101 = r100.c();
        if (r101 == null) goto L9;
        r101.a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.e3.f443690a);
        return;
    L9:
        return;
    }

    public final UDButton ca0() {
        View r100 = this.f442551h;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.button_create);
    L8:
        this.f442551h = (UDButton) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (UDButton) r100;
    }

    public final ImageView da0() {
        View r100 = this.f442552i;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.input_expand);
    L8:
        this.f442552i = (ImageView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (ImageView) r100;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f442551h = null;
        this.f442552i = null;
        this.f442553j = null;
        this.f442554k = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.f442555l == false) goto L12;
        com.larksuite.framework.section.g<p, TodoDetailModel> r100 = this.f442556m;
        if (r100 == null) goto L13;
        TodoDetailModel r101 = (TodoDetailModel) r100.f285689b;
        if (r101 == null) goto L14;
        MutableLiveData<Boolean> r102 = r101.getKeyboardSummaryRequestFocus();
        if (r102 == null) goto L15;
        r102.postValue(Boolean.TRUE);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public TodoKeyboardFragment() {
    }

    @Override // com.ss.android.lark.todo.impl.features.detail.DetailBaseFragment
    public final boolean W90() {
        return this.f442558o;
    }

    public static final void ba0(TodoKeyboardFragment r100) {
        boolean r101 = true;
        if (r100.f442557n <= 0) goto L5;
        boolean r102 = true;
    L6:
        com.larksuite.framework.section.g<p, TodoDetailModel> r103 = r100.f442556m;
        if (r103 == null) goto L31;
        p r104 = (p) r103.f285689b;
        if (r104 == null) goto L31;
        LiveData<List<TodoAttachmentData>> r105 = r104.getAttachments();
        if (r105 == null) goto L31;
        List<TodoAttachmentData> r106 = r105.getValue();
        if (r106 == null) goto L31;
        List<TodoAttachmentData> r107 = r106;
        if ((r107 instanceof Collection) == true) goto L17;
    L19:
        Iterator<T> r108 = r107.iterator();
    L21:
        if (r108.hasNext() == false) goto L31;
        String r109 = ((TodoAttachmentData) r108.next()).getFileToken();
        if (r109 != null) goto L25;
    L28:
        boolean r110 = true;
    L29:
        if (r110 == false) goto L21;
        boolean r111 = false;
    L32:
        if (r102 == false) goto L35;
        if (r111 == false) goto L35;
    L36:
        UDButton r112 = r100.ca0();
        if (r112 == null) goto L39;
        r112.setEnabled(r101);
    L39:
        UDButton r113 = r100.ca0();
        if (r113 == null) goto L52;
        i r114 = i.f444291a;
        if (r101 == false) goto L44;
        int r115 = R.color.primary_fill_default;
    L45:
        r113.setStrokeColor(r114.a(r115));
        return;
    L44:
        r115 = R.color.text_disable;
        goto L45
    L52:
        return;
    L35:
        r101 = false;
        goto L36
    L25:
        if (r109.length() == 0) goto L28;
        r110 = false;
        goto L29
    L17:
        if (r107.isEmpty() == false) goto L19;
    L31:
        r111 = true;
        goto L32
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.ss.android.lark.todo.impl.features.detail.DetailBaseFragment
    public final void V90(com.larksuite.framework.section.g<p, TodoDetailModel> r110) {
        Intrinsics.checkNotNullParameter(r110, "sectionMgr");
        final View r100 = getView();
        if (r100 == null) goto L21;
        this.f442556m = r110;
        a9c.b.b(a9c.b.f2313a, "todo_quick_create_view", new JSONObject(), 4);
        ca0().setEnabled(false);
        ca0().setStrokeColor(i.f444291a.a(R.color.text_disable));
        com.larksuite.framework.section.g<p, TodoDetailModel> r101 = this.f442556m;
        if (r101 == null) goto L7;
        com.larksuite.framework.section.utils.e r102 = new com.larksuite.framework.section.utils.e(ca0());
        com.larksuite.framework.section.c r103 = r101.c();
        com.ss.android.lark.todo.impl.features.detail.viewmodel.a.a2 r104 = com.ss.android.lark.todo.impl.features.detail.viewmodel.a.a2.f443665a;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        Intrinsics.checkNotNullParameter(r103, "dispatcher");
        Intrinsics.checkNotNullParameter(r104, "action");
        r102.f285715a.setOnClickListener(new com.larksuite.framework.section.utils.c(r102, 1000, r103, r104));
    L7:
        da0().setOnClickListener(new f(this));
        Ref.IntRef r105 = new Ref.IntRef();
        com.larksuite.framework.section.g<p, TodoDetailModel> r106 = this.f442556m;
        if (r106 != null) goto L10;
    L12:
        View r107 = this.f442553j;
        if (r107 != null) goto L19;
        View r108 = getView();
        if (r108 == null) goto L17;
        r107 = r108.findViewById(R.id.selected_condition_list);
    L18:
        this.f442553j = (KeyboardScrollView) r107;
        goto L19
    L17:
        r107 = null;
    L19:
        ((KeyboardScrollView) r107).setOnScrollChangeListener(new g(this, r105));
        r110.h(new TodoKeyboardFragment$initMVComposer$1$1(r100));
        r110.h(new TodoKeyboardFragment$initMVComposer$1$2(r100));
        r110.h(new TodoKeyboardFragment$initMVComposer$1$3(this));
        r110.h(new TodoKeyboardFragment$initMVComposer$1$4(r100));
        return;
    L10:
        if (r106.provideContext() == null) goto L12;
        r105.element = UIUtils.dp2px(getContext(), 16.0f);
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.todo.impl.features.detail.DetailBaseFragment
    public final void X90(boolean r100) {
        this.f442555l = r100;
        if (r100 == false) goto L17;
        com.larksuite.framework.section.g<p, TodoDetailModel> r101 = this.f442556m;
        if (r101 == null) goto L9;
        com.larksuite.framework.section.c r102 = r101.c();
        if (r102 == null) goto L9;
        r102.a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.d2.f443683a);
    L9:
        com.larksuite.framework.section.g<p, TodoDetailModel> r103 = this.f442556m;
        if (r103 == null) goto L18;
        TodoDetailModel r104 = (TodoDetailModel) r103.f285689b;
        if (r104 == null) goto L19;
        MutableLiveData<Boolean> r105 = r104.getKeyboardSummaryRequestFocus();
        if (r105 == null) goto L20;
        r105.postValue(Boolean.TRUE);
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return S90(r100, R.layout.todo_keyboard);
    }
}
