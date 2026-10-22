package com.bytedance.ee.bear.lark.selector;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.component.ui.avatar.AvatarType;
import com.larksuite.component.ui.avatar.ImageKeyType;
import com.larus.im.internal.network.proto2.AvCmd;
import com.larus.nova.R;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import sz7.q;
import sz7.u;
import sz7.v;
import sz7.w;
import sz7.x;

/* JADX INFO: loaded from: classes16.dex */
public class DocsConfirmAdapter extends LarkRecyclerViewBaseAdapter<ViewHolder, DocSelectorViewData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f227472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f227473b;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(12967)
        TextView mDescTV;

        @BindView(AvCmd.CommandEventType.TRIGGER_CLIENT_SUMMON_NOTICE_VALUE)
        TextView mNameTV;

        @BindView(14374)
        View mRmBtn;

        @BindView(12656)
        ImageView mSingleAvatorIV;

        public ViewHolder(View r100) {
            super(r100);
            ButterKnife.bind(this, r100);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ViewHolder f227474a;

        @Override // butterknife.Unbinder
        public final void unbind() {
            ViewHolder r100 = this.f227474a;
            if (r100 == null) goto L7;
            this.f227474a = null;
            r100.mSingleAvatorIV = null;
            r100.mNameTV = null;
            r100.mDescTV = null;
            r100.mRmBtn = null;
            return;
        L7:
            throw new IllegalStateException("Bindings already cleared.");
        }

        public ViewHolder_ViewBinding(ViewHolder r100, View r101) {
            this.f227474a = r100;
            r100.mSingleAvatorIV = (ImageView) Utils.findRequiredViewAsType(r101, R.id.group_avatar, "field 'mSingleAvatorIV'", ImageView.class);
            r100.mNameTV = (TextView) Utils.findRequiredViewAsType(r101, R.id.item_title, "field 'mNameTV'", TextView.class);
            r100.mDescTV = (TextView) Utils.findRequiredViewAsType(r101, R.id.item_desc, "field 'mDescTV'", TextView.class);
            r100.mRmBtn = Utils.findRequiredView(r101, R.id.rm_btn, "field 'mRmBtn'");
        }
    }

    public interface a {
    }

    public DocsConfirmAdapter(Context r100) {
        this.f227472a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r210, int r211) {
        ViewHolder r100 = (ViewHolder) r210;
        DocSelectorViewData r101 = getItem(r211);
        boolean r102 = v.f544033a;
        if (v.a.a() == false) goto L50;
        sz7.d r103 = new sz7.d();
        r103.f543992a = r101.icon.getValue();
        ImageKeyType r104 = r101.getImageKeyType();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r103.f543993b = r104;
        r101.docType.getNumber();
        r103.f543989e = r101.title;
        Context r105 = this.f227472a;
        Intrinsics.checkNotNullParameter(r105, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r105, PerfLog.PARAM_KEY_CONTEXT_ID);
        AvatarType r110 = AvatarType.DOC;
        AvatarModel.Size r111 = AvatarModel.Size.MINI;
        ImageView r106 = r100.mSingleAvatorIV;
        Intrinsics.checkNotNullParameter(r106, "imageView");
        u r112 = new u(r106);
        Intrinsics.checkNotNullParameter(r112, "avatarTarget");
        sz7.c r113 = new sz7.c();
        sz7.a r114 = new sz7.a();
        x r115 = new x();
        Intrinsics.checkNotNullParameter(sz7.d.class, "modelClass");
        sz7.b<? extends sz7.g> r107 = v.f544035c.get(sz7.d.class);
        if (r107 != null) goto L7;
        r107 = new sz7.f(r105);
    L7:
        r107.a(r105, r103, r114, r113, r115);
        if (r110 == null) goto L42;
        int r108 = w.f544037a[r110.ordinal()];
        boolean r109 = true;
        if (r108 == 1) goto L24;
        if (r108 == 2) goto L18;
        if (r108 != 3) goto L29;
        int r116 = R.drawable.icon_feed_mini_app;
    L31:
        if (v.a.a() == false) goto L33;
    L38:
        if (r109 == false) goto L41;
        if (r116 <= 0) goto L41;
        x r117 = r115;
        r117.f544038a = AppCompatResources.getDrawable(r105, r116);
    L46:
        if (r111 == null) goto L48;
        int r118 = r111.getPxValue(r105);
    L49:
        r117.f544039b = r118;
        Intrinsics.checkNotNullParameter(r113, "badgeViewData");
        r112.a(r114);
        r112.b(r117);
    L52:
        if (TextUtils.isEmpty(r101.title) == false) goto L54;
        r100.mNameTV.setText(R.string.Lark_Legacy_DefaultName);
    L55:
        String r119 = UIHelper.mustacheFormat(R.string.Lark_Legacy_ItemDesc, "owner", r101.ownerName);
        r100.mDescTV.setText(r119);
        r100.mDescTV.setVisibility(0);
        r100.mRmBtn.setOnClickListener(new c(this, r101));
        return;
    L54:
        r100.mNameTV.setText(r101.title);
        goto L55
    L48:
        r118 = 0;
    L41:
        r117 = r115;
        goto L46
    L33:
        if (r110 == AvatarType.TOPIC) goto L38;
        if (r110 == AvatarType.THRED) goto L38;
        r109 = false;
    L29:
        r116 = -1;
        goto L31
    L18:
        if (v.f544034b == null) goto L20;
        boolean r120 = FeatureGatingModule.getFeatureGatingService().isEnable("lark_feature_doc_icon_custom");
    L21:
        if (r120 == false) goto L29;
        r116 = R.drawable.icon_feed_topic;
        goto L31
    L20:
        r120 = false;
        goto L21
    L24:
        if (v.f544034b == null) goto L26;
        boolean r121 = FeatureGatingModule.getFeatureGatingService().isEnable("lark_feature_doc_icon_custom");
    L27:
        if (r121 == false) goto L29;
        r116 = R.drawable.icon_feed_thread;
        goto L31
    L26:
        r121 = false;
        goto L27
    L42:
        r117 = r115;
        if (TextUtils.isEmpty(null) == true) goto L46;
        q r122 = new q(r105, false);
        q.d(r122, null, null, -1, -1, null, false, null);
        r117.f544038a = r122;
        goto L46
    L50:
        r100.mSingleAvatorIV.setImageResource(DocModuleInner.a(r101.docType, r101.wikiSubType, r101.title));
        goto L52
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return new ViewHolder(LayoutInflater.from(this.f227472a).inflate(R.layout.docs_confirm_item, r100, false));
    }
}
