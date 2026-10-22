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
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;
import sz7.q;
import sz7.u;
import sz7.v;
import sz7.w;
import sz7.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocsConfirmAdapter extends LarkRecyclerViewBaseAdapter<ViewHolder, DocSelectorViewData> {
    public final Context a;
    public a b;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(12967)
        TextView mDescTV;

        @BindView(13012)
        TextView mNameTV;

        @BindView(14374)
        View mRmBtn;

        @BindView(12656)
        ImageView mSingleAvatorIV;

        public ViewHolder(View r1) {
            super(r1);
            ButterKnife.bind(this, r1);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        public ViewHolder a;

        public final void unbind() {
            ViewHolder r0 = this.a;
            if (r0 == null) goto L7;
            this.a = null;
            r0.mSingleAvatorIV = null;
            r0.mNameTV = null;
            r0.mDescTV = null;
            r0.mRmBtn = null;
            return;
        L7:
            throw new IllegalStateException("Bindings already cleared.");
        }

        public ViewHolder_ViewBinding(ViewHolder r4, View r5) {
            this.a = r4;
            r4.mSingleAvatorIV = (ImageView) Utils.findRequiredViewAsType(r5, 2131373927, "field 'mSingleAvatorIV'", ImageView.class);
            r4.mNameTV = (TextView) Utils.findRequiredViewAsType(r5, 2131375867, "field 'mNameTV'", TextView.class);
            r4.mDescTV = (TextView) Utils.findRequiredViewAsType(r5, 2131375727, "field 'mDescTV'", TextView.class);
            r4.mRmBtn = Utils.findRequiredView(r5, 2131384733, "field 'mRmBtn'");
        }
    }

    public interface a {
    }

    public DocsConfirmAdapter(Context r1) {
        this.a = r1;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r26, int r27) {
        ViewHolder r1 = (ViewHolder) r26;
        DocSelectorViewData r2 = (DocSelectorViewData) getItem(r27);
        boolean r3 = v.a;
        if (v.a.a() == false) goto L50;
        sz7.d r7 = new sz7.d();
        ((sz7.g) r7).a = r2.icon.getValue();
        ImageKeyType r4 = r2.getImageKeyType();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        ((sz7.g) r7).b = r4;
        r2.docType.getNumber();
        r7.e = r2.title;
        Context r5 = this.a;
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r5, "context");
        AvatarType r11 = AvatarType.DOC;
        AvatarModel.Size r12 = AvatarModel.Size.MINI;
        ImageView r6 = r1.mSingleAvatorIV;
        Intrinsics.checkNotNullParameter(r6, "imageView");
        u r13 = new u(r6);
        Intrinsics.checkNotNullParameter(r13, "avatarTarget");
        sz7.c r14 = new sz7.c();
        sz7.a r16 = new sz7.a();
        x r10 = new x();
        Intrinsics.checkNotNullParameter(sz7.d.class, "modelClass");
        sz7.f r8 = (sz7.b) v.c.get(sz7.d.class);
        if (r8 != null) goto L7;
        r8 = new sz7.f(r5);
    L7:
        r8.a(r5, r7, r16, r14, r10);
        if (r11 == null) goto L42;
        int r9 = w.a[r11.ordinal()];
        boolean r17 = true;
        if (r9 == 1) goto L24;
        if (r9 == 2) goto L18;
        if (r9 != 3) goto L29;
        int r18 = 2131237823;
    L31:
        if (v.a.a() == false) goto L33;
    L38:
        if (r17 == false) goto L41;
        if (r18 <= 0) goto L41;
        x r19 = r10;
        r19.a = AppCompatResources.getDrawable(r5, r18);
    L46:
        if (r12 == null) goto L48;
        int r20 = r12.getPxValue(r5);
    L49:
        r19.b = r20;
        Intrinsics.checkNotNullParameter(r14, "badgeViewData");
        r13.a(r16);
        r13.b(r19);
    L52:
        if (TextUtils.isEmpty(r2.title) == false) goto L54;
        r1.mNameTV.setText(2131891661);
    L55:
        String r21 = UIHelper.mustacheFormat(2131891853, "owner", r2.ownerName);
        r1.mDescTV.setText(r21);
        r1.mDescTV.setVisibility(0);
        r1.mRmBtn.setOnClickListener(new c(this, r2));
        return;
    L54:
        r1.mNameTV.setText(r2.title);
        goto L55
    L48:
        r20 = 0;
    L41:
        r19 = r10;
        goto L46
    L33:
        if (r11 == AvatarType.TOPIC) goto L38;
        if (r11 == AvatarType.THRED) goto L38;
        r17 = false;
    L29:
        r18 = -1;
        goto L31
    L18:
        if (v.b == null) goto L20;
        boolean r22 = FeatureGatingModule.getFeatureGatingService().isEnable("lark_feature_doc_icon_custom");
    L21:
        if (r22 == false) goto L29;
        r18 = 2131237827;
        goto L31
    L20:
        r22 = false;
        goto L21
    L24:
        if (v.b == null) goto L26;
        boolean r23 = FeatureGatingModule.getFeatureGatingService().isEnable("lark_feature_doc_icon_custom");
    L27:
        if (r23 == false) goto L29;
        r18 = 2131237826;
        goto L31
    L26:
        r23 = false;
        goto L27
    L42:
        r19 = r10;
        if (TextUtils.isEmpty(null) == true) goto L46;
        q r24 = new q(r5, false);
        q.d(r24, null, null, -1, -1, null, false, null);
        r19.a = r24;
        goto L46
    L50:
        r1.mSingleAvatorIV.setImageResource(DocModuleInner.a(r2.docType, r2.wikiSubType, r2.title));
        goto L52
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        return new ViewHolder(LayoutInflater.from(this.a).inflate(2131560115, r3, false));
    }
}
