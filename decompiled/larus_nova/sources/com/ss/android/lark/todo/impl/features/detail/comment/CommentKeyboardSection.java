package com.ss.android.lark.todo.impl.features.detail.comment;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.lark.pb.todo.v1.TodoAttachment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larksuite.framework.utils.FileUtils;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.keyboard.KeyboardBuilder;
import com.ss.android.lark.keyboard.KeyboardScene;
import com.ss.android.lark.keyboard.dtocompat.Image;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.keyboard.event.HeightChange;
import com.ss.android.lark.keyboard.event.ImeState;
import com.ss.android.lark.keyboard.keyboard2.BasicKeyboard;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;
import com.ss.android.lark.keyboard.plugin.tool.photo.PhotoKBPlugin;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.features.detail.TodoDetailFragment;
import com.ss.android.lark.todo.impl.features.detail.at.TodoAtController;
import com.ss.android.lark.todo.impl.features.detail.at.view.TodoAtView;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.TodoAttachmentData;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.TodoData;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class CommentKeyboardSection extends com.larksuite.framework.section.h<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f442851q = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f442852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Fragment f442853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.larksuite.framework.section.e<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> f442854d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.b f442855e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c0 f442856f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f442857g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TodoAtController f442858h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f442859i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f442860j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<CommentImage> f442861k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<TodoAttachmentData> f442862l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f442863m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final z f442864n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f442865o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public RecyclerView f442866p;

    public static final class a extends PhotoKBPlugin {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final CommentKeyboardSection f442868x;

        public a(CommentKeyboardSection r100, f0 r101) {
            Intrinsics.checkNotNullParameter(r100, "section");
            Intrinsics.checkNotNullParameter(r101, "dependency");
            super(false, r101);
            this.f442868x = r100;
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.photo.PhotoKBPlugin
        public final void L(Image r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "image");
            String r102 = (String) ListProtector.get(r100.getUrls(), 0);
            CommentKeyboardSection.n(this.f442868x, r102, r100);
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.photo.PhotoKBPlugin
        public final void M(List<String> r100, boolean r101, List<Photo> r102) {
            Intrinsics.checkNotNullParameter(r100, "photoPaths");
            Intrinsics.checkNotNullParameter(r102, "photos");
            super.M(r100, r101, r102);
        }
    }

    public static final class b {
    }

    static {
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.larksuite.framework.section.h
    public final void i() {
        Function3<Integer, Integer, Intent, Unit> r100 = new CommentKeyboardSection$registerHandleActivityResult$1(this);
        Intrinsics.checkNotNullParameter(r100, "block");
        this.f285694a.g(r100);
        ArrayList<g8c.b> r101 = g8c.c.f480461a;
        z r102 = this.f442864n;
        Intrinsics.checkNotNullParameter(r102, "listener");
        g8c.c.f480461a.add(r102);
    }

    @Override // com.larksuite.framework.section.h
    public final void m() {
        TodoAtController r100 = this.f442858h;
        if (r100 == null) goto L12;
        TodoAtView r101 = r100.f442766i;
        if (r101 == null) goto L12;
        ValueAnimator r102 = r101.f442792g;
        if (r102 == null) goto L9;
        r102.cancel();
    L9:
        ValueAnimator r103 = r101.f442793h;
        if (r103 == null) goto L12;
        r103.cancel();
    L12:
        ArrayList<g8c.b> r104 = g8c.c.f480461a;
        z r105 = this.f442864n;
        Intrinsics.checkNotNullParameter(r105, "listener");
        g8c.c.f480461a.remove(r105);
    }

    public final void o() {
        Iterator<T> r100 = this.f442862l.iterator();
    L3:
        boolean r101 = false;
        if (r100.hasNext() == false) goto L19;
        Object r102 = r100.next();
        TodoAttachmentData r103 = (TodoAttachmentData) r102;
        String r104 = r103.getFileToken();
        if (r104 != null) goto L8;
    L11:
        boolean r105 = true;
    L12:
        if (r105 == true) goto L14;
    L16:
        boolean r106 = false;
    L17:
        if (r106 == false) goto L3;
    L20:
        if (r102 == null) goto L22;
        r101 = true;
    L22:
        this.f442854d.c().e(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.a0.f443663a, r101);
        return;
    L14:
        if (r103.getStatusFail() == true) goto L16;
        r106 = true;
        goto L17
    L8:
        if (r104.length() == 0) goto L11;
        r105 = false;
        goto L12
    L19:
        r102 = null;
        goto L20
    }

    public final void p() {
        ((ArrayList) this.f442861k).clear();
        ((ArrayList) this.f442862l).clear();
        c0 r100 = this.f442856f;
        if (r100 == null) goto L9;
        RecyclerView r101 = r100.f428660y;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mImagesContainer");
        r101 = null;
    L7:
        if (r101 == null) goto L9;
        r101.removeAllViews();
    L9:
        RecyclerView r102 = this.f442866p;
        if (r102 == null) goto L12;
        r102.removeAllViews();
    L12:
        v();
    }

    public final EditText q() {
        c0 r100 = this.f442856f;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.c();
    }

    public final void t() {
        ((FrameLayout) this.f442852b.findViewById(R.id.keyboardContainer)).setVisibility(8);
        if (this.f442863m == false) goto L8;
        this.f442863m = false;
        com.ss.android.lark.keyboard.b r100 = this.f442855e;
        if (r100 == null) goto L9;
        com.ss.android.lark.c.b(r100);
        return;
    L9:
        return;
    }

    public final boolean u() {
        List<TodoAttachmentData> r100 = this.f442862l;
        if ((r100 instanceof Collection) == true) goto L5;
    L7:
        Iterator r101 = ((ArrayList) r100).iterator();
    L9:
        if (r101.hasNext() == false) goto L20;
        String r102 = ((TodoAttachmentData) r101.next()).getFileToken();
        if (r102 != null) goto L13;
    L16:
        boolean r103 = true;
    L18:
        if ((!r103) == false) goto L9;
        boolean r104 = false;
    L22:
        if (((ArrayList) this.f442861k).isEmpty() == false) goto L35;
        if (r104 == false) goto L36;
        EditText r105 = q();
        if (r105 == null) goto L27;
        RichText r106 = com.ss.android.lark.todo.impl.features.common.richtext2.b.b((FunctionEditText) r105);
    L29:
        if (com.ss.android.lark.widget.richtext.i.l(r106) == false) goto L37;
        return true;
    L37:
        return false;
    L27:
        r106 = null;
        goto L29
    L36:
        return false;
    L35:
        return false;
    L13:
        if (r102.length() == 0) goto L16;
        r103 = false;
    L20:
        r104 = true;
        goto L22
    L5:
        if (((ArrayList) r100).isEmpty() == false) goto L7;
        goto L7
    }

    public final void v() {
        boolean r100 = !((ArrayList) this.f442861k).isEmpty();
        boolean r101 = !((ArrayList) this.f442862l).isEmpty();
        List<TodoAttachmentData> r102 = this.f442862l;
        boolean r103 = false;
        if ((r102 instanceof Collection) == true) goto L5;
    L7:
        Iterator r104 = ((ArrayList) r102).iterator();
    L9:
        if (r104.hasNext() == false) goto L19;
        String r105 = ((TodoAttachmentData) r104.next()).getFileToken();
        if (r105 != null) goto L13;
    L16:
        boolean r106 = true;
    L17:
        if (r106 == false) goto L9;
        boolean r107 = false;
    L20:
        if (r100 == true) goto L22;
        if (r101 == true) goto L22;
    L23:
        if (r101 == true) goto L26;
        r107 = true;
    L26:
        c0 r108 = this.f442856f;
        if (r108 == null) goto L41;
        r108.F = r103;
        r108.G = r107;
        KeyboardFunctionEditText r109 = r108.f428650o;
        CharSequence r110 = null;
        if (r109 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r109 = null;
    L31:
        Editable r111 = r109.getText();
        if (r111 == null) goto L34;
        r110 = StringsKt.trim(r111);
    L34:
        r108.u(true ^ TextUtils.isEmpty(r110));
        return;
    L41:
        return;
    L22:
        r103 = true;
        goto L23
    L13:
        if (r105.length() == 0) goto L16;
        r106 = false;
    L19:
        r107 = true;
        goto L20
    L5:
        if (((ArrayList) r102).isEmpty() == false) goto L7;
        goto L7
    }

    @Override // com.larksuite.framework.section.h
    public final void j() {
        com.ss.android.lark.todo.impl.features.detail.viewmodel.p r100 = e();
        k(r100.getCommentDraftLv(), new CommentKeyboardSection$initViewObserver$1$1(this));
        k(r100.getCommentKeyboardVisible(), new CommentKeyboardSection$initViewObserver$1$2(this));
        k(r100.getCommentAtUserInfo(), new CommentKeyboardSection$initViewObserver$1$3(this));
        k(r100.getCommentInitChatId(), new CommentKeyboardSection$initViewObserver$1$4(this));
        k(r100.getCommentInsertAtTag(), new CommentKeyboardSection$initViewObserver$1$5(this));
    }

    @Override // com.larksuite.framework.section.h
    public final void f(com.ss.android.lark.todo.impl.features.detail.viewmodel.a r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (Intrinsics.areEqual(r100, com.ss.android.lark.todo.impl.features.detail.viewmodel.a.k2.f443725a) == false) goto L10;
        com.ss.android.lark.keyboard.b r101 = this.f442855e;
        if (r101 == null) goto L11;
        com.ss.android.lark.keyboard.ime.a r102 = r101.z();
        if (r102 == null) goto L12;
        r102.z();
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void r(String r100) {
        String r101 = com.larksuite.framework.utils.l0.a().toString();
        VFSFile r102 = VFSFiles.f444819b.i(r100);
        String[] r103 = FileUtils.f285888a;
        long r104 = r102.length();
        String r105 = FileUtils.l(r100);
        ArrayList<g8c.b> r106 = g8c.c.f480461a;
        Intrinsics.checkNotNull(r105);
        s(r101, g8c.c.f(r101, r100, r105), r105, r104);
    }

    public CommentKeyboardSection(View r100, TodoDetailFragment r110, com.larksuite.framework.section.g r111) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r110, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r111, "viewAbility");
        super(r111);
        this.f442852b = r100;
        this.f442853c = r110;
        this.f442854d = r111;
        this.f442859i = TodoDependencyHolder.a().loginDependency().getUserId();
        this.f442860j = r100.findViewById(R.id.todo_content_wrapper);
        this.f442861k = new ArrayList();
        this.f442862l = new ArrayList();
        new ArrayList();
        this.f442858h = new TodoAtController(getContext(), c(), new w(this), false, true, 16);
        FragmentActivity r112 = c().getActivity();
        if (r112 == null) goto L5;
        int r101 = KeyboardBuilder.f428200g;
        BaseFragment r102 = c();
        Intrinsics.checkNotNullParameter(r112, PerfLog.PARAM_KEY_CONTEXT_ID);
        KeyboardBuilder.b r103 = new KeyboardBuilder.b(r112, r102);
        KeyboardScene r113 = KeyboardScene.UNKNOWN;
        Intrinsics.checkNotNullParameter(r113, "scene");
        r103.f428205e = r113;
        Lifecycle r114 = r111.f().getLifecycle();
        Intrinsics.checkNotNullParameter(r114, NewBroadcastMonitor.STAGE.LIFECYCLE);
        r103.f428206f = r114;
        c0 r115 = new c0(this, UIHelper.getString(R.string.Todo_Task_AddAComment), UIHelper.getColor(R.color.text_placeholder), new d0(), new e0(this));
        InputSupportType r116 = InputSupportType.Post;
        Intrinsics.checkNotNullParameter(r116, RemoteMessageConst.INPUT_TYPE);
        r115.A = r116;
        this.f442856f = r115;
        r103.c(r115);
        Function1<com.ss.android.lark.keyboard.keyboard2.d, Unit> r117 = new CommentKeyboardSection$2$1$1(this);
        Intrinsics.checkNotNullParameter(r117, "buildAction");
        r103.f428203c = r117;
        this.f442855e = r103.b((ViewGroup) r100.findViewById(R.id.keyboardContainer));
    L5:
        com.ss.android.lark.keyboard.b r104 = this.f442855e;
        if (r104 == null) goto L13;
        com.ss.android.lark.keyboard.event.l r118 = r104.e().of(this);
        r118.d(ImeState.class, new CommentKeyboardSection$3$1$1(this));
        r118.c(HeightChange.class, new CommentKeyboardSection$3$1$2(this));
        Intrinsics.checkNotNullParameter(r104, "<this>");
        if ((r104 instanceof BasicKeyboard) == false) goto L10;
        ViewGroup r105 = ((BasicKeyboard) r104).f429440f.f429517f;
    L11:
        if (r105 == null) goto L13;
        r105.setBackgroundResource(R.color.bg_body);
        goto L13
    L10:
        r105 = null;
    L13:
        t();
        this.f442864n = new z(this);
    }

    public static final void n(CommentKeyboardSection r100, String r101, Image r102) {
        r100.getClass();
        VFSFile r103 = VFSFiles.f444819b.i(r101);
        String[] r104 = FileUtils.f285888a;
        long r105 = r103.length();
        TodoAttachment r106 = new TodoAttachment.Builder().type(TodoAttachment.Type.IMAGE).file_token(r102.getToken()).file_size(String.valueOf(r105)).name((String) CollectionsKt.firstOrNull(r102.getUrls())).uploader_user_id(r100.f442859i).build();
        CommentImage.Companion.ImageInfoType r107 = CommentImage.Companion.ImageInfoType.PATH;
        Intrinsics.checkNotNull(r106);
        com.bytedance.ee.lark.infra.foundation.utils.c.a(new y(r100, CollectionsKt.listOf(new CommentImage(r101, r107, r106))));
        int r108 = a9c.c.f2314a;
        TodoData r109 = r100.e().getTodoDataLiveData().getValue();
        if (r109 == null) goto L5;
        String r110 = r109.getGuid();
    L6:
        a9c.c.f("upload_image", r110);
        return;
    L5:
        r110 = null;
        goto L6
    }

    public final void s(String r100, String r101, String r102, long r103) {
        long r104 = System.currentTimeMillis();
        long r105 = this.f442865o;
        if (r104 > r105) goto L5;
        this.f442865o = r105 + 1;
    L6:
        TodoAttachment r106 = new TodoAttachment.Builder().guid(r100).type(TodoAttachment.Type.FILE).can_delete(Boolean.TRUE).file_size(String.valueOf(r103)).name(r102).uploader_user_id(TodoDependencyHolder.a().loginDependency().getUserId()).upload_milli_time(Long.valueOf(this.f442865o)).build();
        Intrinsics.checkNotNull(r106);
        TodoAttachmentData r107 = new TodoAttachmentData(r106);
        r107.setKey(r101);
        com.bytedance.ee.lark.infra.foundation.utils.c.a(new x(this, CollectionsKt.listOf(r107)));
        return;
    L5:
        this.f442865o = r104;
        goto L6
    }
}
