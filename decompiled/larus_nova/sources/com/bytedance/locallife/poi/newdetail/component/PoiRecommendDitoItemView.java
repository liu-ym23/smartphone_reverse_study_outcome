package com.bytedance.locallife.poi.newdetail.component;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.dito.utils.ApplicationUtil;
import com.bytedance.locallife.model.poi.resp.CollectTextConfig;
import com.bytedance.locallife.model.poi.resp.PoiBackendType;
import com.bytedance.locallife.model.poi.resp.SimplePoiInfoStruct;
import com.bytedance.locallife.poi.newdetail.widget.CheckableImageView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.poi.collect.net.PoiCollectResponse;
import com.ss.android.ugc.aweme.poi.collect.net.PoiCollectSceneInfoStruct;
import com.ss.android.ugc.aweme.poi.mob.PoiMobEventParams;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/component/PoiRecommendDitoItemView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiRecommendDitoItemView extends FrameLayout {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f263109n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PoiBundle f263110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final oy6.e f263111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f263112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SimplePoiInfoStruct f263113d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CollectTextConfig f263114e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DuxTextView f263115f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DuxTextView f263116g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DuxTextView f263117h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DuxTextView f263118i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SimpleDraweeView f263119j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinearLayout f263120k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final CheckableImageView f263121l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final DuxTextView f263122m;

    public static final class a implements SingleObserver<PoiCollectResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiRecommendDitoItemView f263123a;

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable r100) {
            Intrinsics.checkNotNullParameter(r100, "d");
        }

        public a(PoiRecommendDitoItemView r100) {
            this.f263123a = r100;
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            PoiRecommendDitoItemView r101 = this.f263123a;
            if (r101.f263112c == false) goto L5;
            Toast.makeText(r101.getContext(), R.string.poi_cancel_collect_list_fail, 0).show();
            return;
        L5:
            Toast.makeText(r101.getContext(), R.string.poi_collect_failed, 0).show();
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(PoiCollectResponse r100) {
            PoiCollectResponse r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "t");
            if (this.f263123a.f263112c == false) goto L12;
            PoiCollectSceneInfoStruct r102 = r101.getSceneInfoStruct();
            if (r102 == null) goto L12;
            PoiRecommendDitoItemView r103 = this.f263123a;
            if (r102.getTaskCounter() <= 0) goto L9;
            StringCompanionObject r104 = StringCompanionObject.INSTANCE;
            Toast.makeText(r103.getContext().getApplicationContext(), String.format(r103.getContext().getResources().getString(R.string.poi_collect_f_count), Arrays.copyOf(new Object[]{Integer.valueOf(r102.getTaskCounter())}, 1)), 0).show();
        L9:
            String r105 = r102.getSchema();
            if (r105 == null) goto L12;
            HostServiceUtilsKt.a0().d(r103.getContext(), r105).a();
        L12:
            ws6.a r106 = HostServiceUtilsKt.t();
            PoiRecommendDitoItemView r107 = this.f263123a;
            boolean r108 = r107.f263112c;
            PoiMobEventParams.Builder r109 = new PoiMobEventParams.Builder();
            SimplePoiInfoStruct r110 = r107.f263113d;
            if (r110 == null) goto L15;
            r110.getPoiId();
        L15:
            PoiBundle r111 = r107.f263110a;
            if (r111 == null) goto L18;
            String r112 = r111.poiId;
        L18:
            SimplePoiInfoStruct r113 = r107.f263113d;
            if (r113 == null) goto L23;
            PoiBackendType r114 = r113.getPoiBackendType();
            if (r114 == null) goto L23;
            String r115 = r114.getCode();
        L24:
            wv6.a.a(r115);
            PoiBundle r116 = r107.f263110a;
            if (r116 == null) goto L27;
            String r117 = r116.backendType;
        L27:
            SimplePoiInfoStruct r118 = r107.f263113d;
            if (r118 == null) goto L30;
            r118.getPoiAddress();
        L30:
            PoiBundle r119 = r107.f263110a;
            if (r119 == null) goto L33;
            String r120 = r119.cityCode;
        L33:
            Context r121 = r107.getContext();
            if ((r121 instanceof Activity) == false) goto L36;
            Activity r122 = (Activity) r121;
        L36:
            PoiBundle r123 = r107.f263110a;
            int r124 = com.bytedance.locallife.poi.poidetail.container.mob.j.f263878a;
            Intrinsics.checkNotNullParameter("favourite_poi", "eventName");
            if (r123 == null) goto L46;
            String r125 = r123.searchParams;
            if (r125 == null) goto L46;
            if (r125.length() != 0) goto L43;
            boolean r126 = true;
        L44:
            if (r126 == true) goto L46;
            Map<String, String> r127 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("search_params", r125)});
        L47:
            r109.f451353a = r127;
            r106.G(new PoiMobEventParams(r109));
            PoiRecommendDitoItemView r128 = this.f263123a;
            r128.f263112c = !r128.f263112c;
            Intrinsics.checkNotNullParameter(r101, "response");
            ws6.a r129 = HostServiceUtilsKt.t();
            SimplePoiInfoStruct r130 = r128.f263113d;
            if (r130 == null) goto L50;
            r130.getPoiId();
        L50:
            Integer r131 = r101.getCollectCount();
            if (r131 == null) goto L53;
            r131.intValue();
        L53:
            r129.M();
            r128.a();
            if (r128.f263112c == true) goto L56;
            Toast.makeText(r128.getContext().getApplicationContext(), R.string.poi_cancel_collect_success, 0).show();
            return;
        L56:
            PoiCollectSceneInfoStruct r132 = r101.getSceneInfoStruct();
            if (r132 != null) goto L59;
            return;
        L59:
            if (r132.getTaskCounter() <= 0) goto L61;
            StringCompanionObject r133 = StringCompanionObject.INSTANCE;
            Toast.makeText(r128.getContext().getApplicationContext(), String.format(r128.getContext().getResources().getString(R.string.poi_collect_f_count), Arrays.copyOf(new Object[]{Integer.valueOf(r132.getTaskCounter())}, 1)), 0).show();
        L61:
            String r134 = r132.getSchema();
            if (r134 == null) goto L67;
            HostServiceUtilsKt.a0().d(r128.getContext(), r134).a();
            return;
        L67:
            return;
        L43:
            r126 = false;
        L46:
            r127 = HostServiceUtilsKt.e0().X();
        L23:
            r115 = null;
            goto L24
        }
    }

    public PoiRecommendDitoItemView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PoiRecommendDitoItemView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        LinearLayout r100 = this.f263120k;
        if (this.f263112c == false) goto L5;
        int r101 = R.drawable.poi_bg_poi_text_tag;
    L6:
        r100.setBackgroundResource(r101);
        CheckableImageView r102 = this.f263121l;
        if (this.f263112c == false) goto L9;
        int r103 = R.drawable.poi_ic_collection;
    L10:
        r102.setImageResource(r103);
        if (this.f263112c == false) goto L17;
        this.f263122m.setTextColor(ContextCompat.getColor(ApplicationUtil.a(), R.color.TextReverse));
        CollectTextConfig r104 = this.f263114e;
        if (r104 == null) goto L23;
        String r105 = r104.getAfter();
        if (r105 == null) goto L24;
        this.f263122m.setText(r105);
        return;
    L24:
        return;
    L23:
        return;
    L17:
        this.f263122m.setTextColor(ContextCompat.getColor(ApplicationUtil.a(), R.color.ConstTextInverse));
        CollectTextConfig r106 = this.f263114e;
        if (r106 == null) goto L26;
        String r107 = r106.getBefore();
        if (r107 == null) goto L27;
        this.f263122m.setText(r107);
        return;
    L27:
        return;
    L26:
        return;
    L9:
        r103 = R.drawable.poi_ic_collect_off;
        goto L10
    L5:
        r101 = R.drawable.poi_bg_collect_deactivated;
        goto L6
    }

    public final void b() {
        SimplePoiInfoStruct r100 = this.f263113d;
        if (r100 != null) goto L5;
        return;
    L5:
        oy6.e r101 = this.f263111b;
        String r102 = r100.getPoiId();
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        String r103 = r102;
        int r104 = !this.f263112c ? 1 : 0;
        PoiBundle r105 = this.f263110a;
        if (r105 == null) goto L11;
        String r106 = r105.fTask;
    L12:
        if (r105 == null) goto L14;
        String r107 = r105.fToken;
    L15:
        if (r105 == null) goto L17;
        String r108 = r105.fSceneName;
    L18:
        r101.a(r103, r104, null, r106, r107, r108, null, false).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        return;
    L17:
        r108 = null;
        goto L18
    L14:
        r107 = null;
        goto L15
    L11:
        r106 = null;
        goto L12
    }

    public PoiRecommendDitoItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        int r103 = oy6.f.f527139a;
        qt6.b r104 = HostServiceUtilsKt.S();
        r104.h();
        this.f263111b = (oy6.e) r104.create("https://life-service-open.scsjsd.com", oy6.e.class);
        LayoutInflater.from(r100).inflate(R.layout.saas_poi_commponent_collect_recommend_item, this);
        this.f263115f = (DuxTextView) findViewById(R.id.poi_recommend_collect_title);
        this.f263116g = (DuxTextView) findViewById(R.id.poi_recommend_message_rank);
        this.f263117h = (DuxTextView) findViewById(R.id.poi_recommend_message_label);
        this.f263118i = (DuxTextView) findViewById(R.id.poi_recommend_message_type);
        this.f263119j = (SimpleDraweeView) findViewById(R.id.poi_recommend_collect_img);
        this.f263120k = (LinearLayout) findViewById(R.id.poi_recommend_collect_btn);
        this.f263121l = (CheckableImageView) findViewById(R.id.poi_recommend_collect_btn_ic);
        this.f263122m = (DuxTextView) findViewById(R.id.poi_recommend_collect_btn_text);
    }

    public /* synthetic */ PoiRecommendDitoItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
