package com.ss.android.lark.todo.impl.features.detail.at;

import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.todo.v1.GetRecommendedContentsRequest;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.search.dto.Scene;
import com.ss.android.lark.search.dto.SearchResponse;
import com.ss.android.lark.search.dto.service.SearchContext;
import com.ss.android.lark.todo.impl.features.detail.at.model.TodoAtModel;
import com.ss.android.lark.todo.impl.features.detail.at.model.TodoAtModel$getTodoMentionList$callback$1;
import com.ss.android.lark.todo.impl.features.detail.at.model.TodoAtModel$getTodoRecommendList$callback$1;
import com.ss.android.lark.todo.impl.features.detail.at.model.TodoAtModel$getTodoSearchList$callback$1;
import com.ss.android.lark.todo.impl.features.detail.at.model.TodoAtViewModel;
import com.ss.android.lark.todo.impl.features.detail.at.view.TodoAtView;
import com.ss.android.lark.todo.impl.utils.g;
import com.ss.android.lark.utils.q0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Date;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class TodoAtController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f442758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f442759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f442760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f442761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f442762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f442763f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public EditText f442764g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FrameLayout f442765h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TodoAtView f442766i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f442767j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TodoAtViewModel f442768k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TodoAtModel f442769l;

    public static final class a {
    }

    public interface b {
        void a(boolean r100);

        void b();

        void c(String r100, String r101);

        void d(String r100);
    }

    public static final class c extends q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TodoAtController f442770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EditText f442771b;

        public c(TodoAtController r100, EditText r101) {
            this.f442770a = r100;
            this.f442771b = r101;
        }

        @Override // com.ss.android.lark.utils.q0, android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
            if (r100 == null) goto L18;
            TodoAtController r104 = this.f442770a;
            boolean r105 = true;
            if (r102 != 1) goto L19;
            if (r103 != 0) goto L20;
            boolean r106 = false;
            if (r100.charAt(r101) == '@') goto L10;
            r105 = false;
        L10:
            if (r105 == false) goto L21;
            TodoAtView r107 = r104.f442766i;
            if (r107 == null) goto L14;
            r106 = r107.f442797l;
        L14:
            if (r106 == false) goto L22;
            if (r107 == null) goto L23;
            r107.S5();
            return;
        L23:
            return;
        L22:
            return;
        L21:
            return;
        L20:
            return;
        L19:
            return;
        }

        @Override // com.ss.android.lark.utils.q0, android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            if (r100 == null) goto L30;
            TodoAtController r104 = this.f442770a;
            EditText r105 = this.f442771b;
            boolean r106 = false;
            if (StringsKt.contains$default(r100, '@', false, 2, null) == false) goto L26;
            TodoAtView r107 = r104.f442766i;
            if (r107 == null) goto L8;
            boolean r108 = r107.f442796k;
        L9:
            if (r108 == false) goto L12;
            TodoAtController.a(r104, r105.getText().toString());
            return;
        L12:
            if (r103 == 1) goto L14;
            return;
        L14:
            if (r100.charAt(r101) != '@') goto L16;
            r106 = true;
        L16:
            if (r106 == true) goto L18;
            return;
        L18:
            if (r105.hasFocus() == true) goto L21;
            return;
        L21:
            if (r104.f442763f == false) goto L25;
            b r109 = r104.f442760c;
            if (r109 == null) goto L34;
            r109.b();
            return;
        L34:
            return;
        L25:
            TodoAtController.a(r104, r105.getText().toString());
            return;
        L8:
            r108 = false;
            goto L9
        L26:
            TodoAtView r110 = r104.f442766i;
            if (r110 == null) goto L37;
            r110.S5();
            return;
        L37:
            return;
        }
    }

    public static final class d implements TextView.OnEditorActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TodoAtController f442772a;

        public d(TodoAtController r100) {
            this.f442772a = r100;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
            if (r101 != 5) goto L5;
        L7:
            TodoAtView r103 = this.f442772a.f442766i;
            if (r103 == null) goto L12;
            r103.S5();
            return false;
        L12:
            return false;
        L5:
            if (r101 == 6) goto L7;
            return false;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f442773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TodoAtController f442774b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f442775c;

        public e(EditText r100, TodoAtController r101, String r102) {
            this.f442773a = r100;
            this.f442774b = r101;
            this.f442775c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f442773a.requestFocus();     // Catch: Throwable -> L6
            KeyboardUtils.showKeyboard(this.f442773a);     // Catch: Throwable -> L6
            b r100 = this.f442774b.f442760c;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.d(this.f442775c);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    public final Context getContext() {
        return this.f442758a;
    }

    public static final void a(TodoAtController r110, String r111) {
        int r100 = StringsKt.lastIndexOf$default(r111, "@", 0, false, 6, null);
        EditText r101 = r110.f442764g;
        if (r101 == null) goto L8;
        if (r101.getSelectionEnd() <= 0) goto L8;
        r100 = StringsKt.lastIndexOf$default(r111, "@", r101.getSelectionEnd(), false, 4, null);
    L8:
        if (r100 != (-1)) goto L10;
        Log.e("TodoAtController", "not found at for search key");
        return;
    L10:
        int r102 = r100 + 1;
        EditText r103 = r110.f442764g;
        if (r103 != null) goto L13;
    L15:
        int r104 = r102;
    L16:
        TodoAtView r105 = r110.f442766i;
        if (r105 == null) goto L19;
        r105.setPreActive(true);
    L19:
        String r112 = r111.substring(r102, r104);
        final TodoAtModel r106 = null;
        if (r110.f442766i != null) goto L28;
        Context r107 = r110.f442758a;
        Fragment r108 = r110.f442759b;
        TodoAtViewModel r109 = r110.f442768k;
        if (r109 == null) goto L24;
        TodoAtViewModel r113 = r109;
    L25:
        TodoAtView r114 = new TodoAtView(r107, r108, r113, r110.f442761d, new com.ss.android.lark.todo.impl.features.detail.at.b(r110));
        r110.f442766i = r114;
        r114.setVisibility(8);
        FrameLayout r115 = r110.f442765h;
        if (r115 == null) goto L28;
        r115.addView(r110.f442766i, new ConstraintLayout.LayoutParams(-1, -1));
        goto L28
    L24:
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        r113 = null;
    L28:
        TodoAtModel r116 = r110.f442769l;
        if (r116 == null) goto L31;
        r106 = r116;
    L32:
        r106.getClass();
        Intrinsics.checkNotNullParameter(r112, "key");
        if (TextUtils.isEmpty(r112) == true) goto L35;
        r106.f442783d = TodoAtModel.CurrentLoadState.LOAD_SEARCH;
        final String r117 = String.valueOf(new Date().getTime());
        final String r118 = "getDataFromSearch";
        Log.i("TodoAtModel", g.e(r117, "getDataFromSearch", new String[0]));
        IGetDataCallback<SearchResponse> r119 = new TodoAtModel$getTodoSearchList$callback$1(r106, r117, r118);
        z3c.a r120 = (z3c.a) r106.f442782c.getValue();
        SearchContext r121 = new SearchContext();
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        r121.f440173b = r112;
        r121.a(Scene.Type.SEARCH_USERS);
        r121.f440178g = true;
        r121.f440192u = 50;
        Unit r122 = Unit.INSTANCE;
        r120.onSearch(r117, r121, r119);
    L42:
        r110.f442767j = r112;
        return;
    L35:
        String r123 = r106.f442781b;
        if (r123 != null) goto L38;
    L41:
        r106.f442783d = TodoAtModel.CurrentLoadState.LOAD_TODO_RECOMMEND;
        final String r124 = String.valueOf(new Date().getTime());
        final String r125 = "getDataFromRecommend";
        Log.i("TodoAtModel", g.e(r124, "getDataFromRecommend", new String[0]));
        IGetDataCallback<e8c.b> r126 = new TodoAtModel$getTodoRecommendList$callback$1(r106, r124, r125);
        int r127 = d8c.b.f467447a;
        Intrinsics.checkNotNullParameter(r126, "callback");
        GetRecommendedContentsRequest.Builder r128 = new GetRecommendedContentsRequest.Builder();
        r128.count(50);
        SdkSender.asynSendRequestNonWrap(Command.GET_RECOMMENDED_CONTENTS, r128, r126, d8c.c.f467449a);
        goto L42
    L38:
        if (Intrinsics.areEqual(r123, "") == true) goto L41;
        r106.f442783d = TodoAtModel.CurrentLoadState.LOAD_CHAT_MENTION;
        final String r129 = String.valueOf(new Date().getTime());
        final String r130 = "getDataFromMention";
        Log.i("TodoAtModel", g.e(r129, "getDataFromMention", new String[0]));
        IGetDataCallback<e8c.a> r131 = new TodoAtModel$getTodoMentionList$callback$1(r106, r129, r130);
        int r132 = d8c.b.f467447a;
        d8c.b.a.a(r123, r112, r131);
        goto L42
    L31:
        Intrinsics.throwUninitializedPropertyAccessException("mModel");
        goto L32
    L13:
        if (r103.getSelectionEnd() < r102) goto L15;
        r104 = r103.getSelectionEnd();
        goto L16
    }

    public final void b(EditText r100, FrameLayout r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "editText");
        this.f442764g = r100;
        this.f442765h = r101;
        TodoAtViewModel r103 = (TodoAtViewModel) new ViewModelProvider(this.f442759b, new TodoAtController$bind$1()).get(String.valueOf(r100.getId()), TodoAtViewModel.class);
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f442768k = r103;
        TodoAtViewModel r104 = this.f442768k;
        if (r104 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        r104 = null;
    L6:
        TodoAtModel r105 = new TodoAtModel(r104, r102);
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        this.f442769l = r105;
        EditText r106 = this.f442764g;
        if (r106 == null) goto L12;
        r106.addTextChangedListener(new c(this, r106));
        if (this.f442762e == false) goto L13;
        r106.setOnEditorActionListener(new d(this));
        return;
    L13:
        return;
    }

    public final void c(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "chatterId");
        Intrinsics.checkNotNullParameter(r101, CommonConstant.KEY_DISPLAY_NAME);
        EditText r103 = this.f442764g;
        if (r103 == null) goto L6;
        com.ss.android.lark.todo.impl.features.common.richtext2.b.c(r103, r100, r101, r102);
        r103.post(new e(r103, this, r100));
        return;
    }

    public TodoAtController(Context r100, BaseFragment r101, b r102, boolean r103, boolean r104, int r105) {
        if ((r105 & 16) == 0) goto L5;
        boolean r106 = true;
    L7:
        if ((r105 & 32) == 0) goto L9;
        r104 = false;
    L9:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        this.f442758a = r100;
        this.f442759b = r101;
        this.f442760c = r102;
        this.f442761d = r103;
        this.f442762e = r106;
        this.f442763f = r104;
        this.f442767j = "";
        return;
    L5:
        r106 = false;
        goto L7
    }
}
