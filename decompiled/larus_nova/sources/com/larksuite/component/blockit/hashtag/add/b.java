package com.larksuite.component.blockit.hashtag.add;

import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.larksuite.component.blockit.entity.TagPermissionType;
import com.larksuite.component.blockit.hashtag.list.HashTagSwipeAdapter;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.ui.DividerDecoration;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f283002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f283003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f283004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f283005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j.a f283006e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HashTagSwipeAdapter f283007f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FragmentActivity f283008g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f283009h;

    public interface a {
        FragmentActivity getActivity();
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        this.f283008g = this.f283003b.getActivity();
        if (this.f283004c == false) goto L5;
        JSONObject r100 = new JSONObject(this.f283005d);
        String r101 = UUID.randomUUID().toString();
        this.f283009h = r101;
        r100.put("session_id", r101);
        qy7.a.a("pano_tag_mention_begin", r100);
        ((CommonTitleBar) this.f283002a.findViewById(R.id.titleBar)).setTitle(R.string.Lark_Pano_AddTopic);
        ((TextView) this.f283002a.findViewById(R.id.tvRecommendDesc)).setText(UIUtils.getString(this.f283008g, R.string.Lark_Pano_RecommendTopic));
    L6:
        EditText r102 = (EditText) this.f283002a.findViewById(R.id.etSearchHashTag);
        r102.addTextChangedListener(new c(this));
        r102.setOnFocusChangeListener(new d(r102, this));
        ((ImageView) this.f283002a.findViewById(R.id.ivSearchDelete)).setOnClickListener(new e(this));
        ((FrameLayout) this.f283002a.findViewById(R.id.flSearchContainer)).setOnClickListener(new f(this));
        ((CommonRecyclerView) this.f283002a.findViewById(R.id.rvHashTags)).setLayoutManager(new LinearLayoutManager(this.f283002a.getContext()));
        DividerDecoration.a r103 = new DividerDecoration.a(this.f283008g);
        float r104 = UIUtils.dp2px(this.f283008g, 0.5f);
        Resources r105 = r103.f285824a;
        r103.f285825b = (int) TypedValue.applyDimension(0, r104, WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()));
        r103.f285826c = r103.f285824a.getColor(R.color.lkui_N300);
        float r106 = UIUtils.dp2px(this.f283008g, 16.0f);
        Resources r107 = r103.f285824a;
        ((CommonRecyclerView) this.f283002a.findViewById(R.id.rvHashTags)).addItemDecoration(new DividerDecoration(r103.f285825b, (int) TypedValue.applyDimension(0, r106, WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics())), r103.f285826c), 0);
        FragmentActivity r108 = this.f283008g;
        if (r108 == null) goto L10;
        this.f283007f = new HashTagSwipeAdapter(r108, new g(this, r108), false, this.f283004c);
        ((CommonRecyclerView) this.f283002a.findViewById(R.id.rvHashTags)).setAdapter(this.f283007f);
        return;
    L10:
        return;
    L5:
        ((CommonTitleBar) this.f283002a.findViewById(R.id.titleBar)).setTitle(R.string.Lark_Pano_Mention_ChoiceTag);
        ((CommonTitleBar) this.f283002a.findViewById(R.id.titleBar)).setLeftImageResource(R.drawable.ic_svg_titlebar_close);
        ((TextView) this.f283002a.findViewById(R.id.tvRecommendDesc)).setText(UIUtils.getString(this.f283008g, R.string.Lark_Pano_Mention_RecommendTag));
        goto L6
    }

    @Override // com.larksuite.component.blockit.hashtag.add.j
    public final void finish() {
        FragmentActivity r100 = this.f283003b.getActivity();
        if (r100 == null) goto L5;
        r100.setResult(-1);
    L5:
        FragmentActivity r101 = this.f283003b.getActivity();
        if (r101 == null) goto L9;
        r101.finish();
        return;
    }

    @Override // com.larksuite.component.blockit.hashtag.add.j
    public final void d5(k r100) {
        Intrinsics.checkNotNullParameter(r100, "initData");
        HashTagSwipeAdapter r101 = this.f283007f;
        if (r101 == null) goto L6;
        r101.A2(r100.f283018a);
    L6:
        if (CollectionUtils.isNotEmpty(r100.f283018a) == false) goto L8;
        ((TextView) this.f283002a.findViewById(R.id.tvRecommendDesc)).setVisibility(0);
        ((CommonRecyclerView) this.f283002a.findViewById(R.id.rvHashTags)).setVisibility(0);
    L10:
        if (this.f283004c == true) goto L13;
        JSONObject r102 = new JSONObject(this.f283005d);
        r102.put("session_id", this.f283009h);
        r102.put("if_input", false);
        qy7.a.a("pano_mention_input_word", r102);
        return;
    L13:
        return;
    L8:
        ((TextView) this.f283002a.findViewById(R.id.tvRecommendDesc)).setVisibility(8);
        ((CommonRecyclerView) this.f283002a.findViewById(R.id.rvHashTags)).setVisibility(8);
        goto L10
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f283006e = (j.a) r100;
    }

    @Override // com.larksuite.component.blockit.hashtag.add.j
    public final void G0(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (r101 == 0) goto L7;
        LKUIToast.show(this.f283008g, r101, r100);
        return;
    L7:
        LKUIToast.show(this.f283008g, r100);
    }

    @Override // com.larksuite.component.blockit.hashtag.add.j
    public final void Q6(String r210, List<oy7.e> r211, boolean r212) {
        Intrinsics.checkNotNullParameter(r210, "query");
        ArrayList r100 = new ArrayList();
        if (this.f283004c == false) goto L8;
        if (r212 == false) goto L8;
        oy7.e r101 = new oy7.e("", "", ((EditText) this.f283002a.findViewById(R.id.etSearchHashTag)).getText().toString(), false, false, true, false, "", "", TagPermissionType.Private.value(), null, true, 1024);
        if (TextUtils.isEmpty(r210) == true) goto L8;
        r100.add(r101);
    L8:
        if (r211 == null) goto L12;
        List r102 = CollectionsKt.toMutableList(r211);
        if (r102 == null) goto L12;
        r100.addAll(r102);
    L12:
        HashTagSwipeAdapter r103 = this.f283007f;
        if (r103 == null) goto L16;
        r103.A2(r100);
    L16:
        if (CollectionUtils.isNotEmpty(r100) == false) goto L18;
        ((CommonRecyclerView) this.f283002a.findViewById(R.id.rvHashTags)).setVisibility(0);
    L20:
        if (TextUtils.isEmpty(r210) == false) goto L22;
    L27:
        ((LinearLayout) this.f283002a.findViewById(R.id.search_empty_container)).setVisibility(8);
    L29:
        if (TextUtils.isEmpty(r210) == true) goto L31;
    L33:
        ((TextView) this.f283002a.findViewById(R.id.tvRecommendDesc)).setVisibility(8);
    L35:
        if (this.f283004c == true) goto L38;
        JSONObject r104 = new JSONObject(this.f283005d);
        r104.put("session_id", this.f283009h);
        r104.put("if_input", !TextUtils.isEmpty(r210));
        qy7.a.a("pano_mention_input_word", r104);
        return;
    L38:
        return;
    L31:
        if (CollectionUtils.isNotEmpty(r211) == false) goto L33;
        ((TextView) this.f283002a.findViewById(R.id.tvRecommendDesc)).setVisibility(0);
        goto L35
    L22:
        if (CollectionUtils.isEmpty(r100) == false) goto L27;
        ((LinearLayout) this.f283002a.findViewById(R.id.search_empty_container)).setVisibility(0);
        String r110 = "未搜索到“" + r210 + "”相关结果";
        int r105 = StringsKt.indexOf$default(r110, r210, 0, false, 6, null);
        int r106 = r210.length() + r105;
        SpannableString r107 = new SpannableString(r110);
        FragmentActivity r108 = this.f283008g;
        if (r108 == null) goto L26;
        r107.setSpan(new ForegroundColorSpan(r108.getResources().getColor(R.color.lkui_B500)), r105, r106, 33);
    L26:
        ((TextView) this.f283002a.findViewById(R.id.tv_search_empty)).setText(r107);
        goto L29
    L18:
        ((CommonRecyclerView) this.f283002a.findViewById(R.id.rvHashTags)).setVisibility(8);
        goto L20
    }

    public b(View r100, AddHashTagFragment.a r101, boolean r102, Map r103) {
        Intrinsics.checkNotNullParameter(r100, "mRootView");
        Intrinsics.checkNotNullParameter(r101, "mViewDependency");
        this.f283002a = r100;
        this.f283003b = r101;
        this.f283004c = r102;
        this.f283005d = r103;
    }
}
