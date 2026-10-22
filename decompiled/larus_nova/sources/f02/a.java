package f02;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c12.m;
import c12.t;
import com.bytedance.android.live.core.resources.e;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.debug.AssetsInfoAdapter;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static a f474960f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f474961g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C5841a f474962h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AssetsInfoAdapter f474963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IAssetsManager f474964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f474965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public m f474966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f474967e;

    /* JADX INFO: renamed from: f02.a$a, reason: collision with other inner class name */
    public static final class C5841a {
        public C5841a() {
        }
    }

    public static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f474968a;

        public b(a r100) {
            this.f474968a = r100;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            super.handleMessage(r100);
            AssetsInfoAdapter r101 = this.f474968a.getAdapter();
            Integer r102 = null;
            if (r101 == null) goto L10;
            LiveData<List<Pair<e, Boolean>>> r103 = this.f474968a.getMAssetsManager().h0();
            if (r103 == null) goto L7;
            List<Pair<e, Boolean>> r104 = r103.getValue();
        L8:
            r101.y2(r104);
            goto L10
        L7:
            r104 = null;
        L10:
            if (this.f474968a.getProducer() != null) goto L14;
            fd6.b<String> r105 = t.f22060d;
            if ((r105 instanceof m) == false) goto L14;
            this.f474968a.setProducer((m) r105);
        L14:
            TextView r106 = this.f474968a.getMCount();
            StringBuilder r107 = new StringBuilder("共:");
            AssetsInfoAdapter r108 = this.f474968a.getAdapter();
            if (r108 == null) goto L17;
            String r109 = r108.f129089c;
        L18:
            r107.append(r109);
            r107.append("\n速(MB/s)：");
            StringCompanionObject r110 = StringCompanionObject.INSTANCE;
            Object[] r111 = new Object[1];
            m r112 = this.f474968a.getProducer();
            if (r112 == null) goto L21;
            Double r113 = Double.valueOf(r112.f22051f);
        L22:
            r111[0] = r113;
            r107.append(String.format("%.2f", Arrays.copyOf(r111, 1)));
            r107.append(" 均速： ");
            Object[] r114 = new Object[1];
            m r115 = this.f474968a.getProducer();
            if (r115 == null) goto L25;
            Double r116 = Double.valueOf(r115.f22049d / r115.f22050e);
        L26:
            r114[0] = r116;
            r107.append(String.format("%.2f", Arrays.copyOf(r114, 1)));
            r107.append("| ");
            m r117 = this.f474968a.getProducer();
            if (r117 == null) goto L29;
            r102 = Integer.valueOf(r117.f22050e);
        L29:
            r107.append(r102);
            r107.append(' ');
            r106.setText(r107.toString());
            sendEmptyMessageDelayed(0, 2000);
            return;
        L25:
            r116 = null;
            goto L26
        L21:
            r113 = null;
            goto L22
        L17:
            r109 = null;
            goto L18
        }
    }

    static {
        f474962h = new C5841a();
    }

    public final IAssetsManager getMAssetsManager() {
        IAssetsManager r100 = this.f474964b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAssetsManager");
    L5:
        return r100;
    }

    public final TextView getMCount() {
        TextView r100 = this.f474965c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mCount");
    L5:
        return r100;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f474967e.sendEmptyMessageDelayed(0, 2000);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f474967e.removeCallbacksAndMessages(null);
    }

    public final AssetsInfoAdapter getAdapter() {
        return this.f474963a;
    }

    public final Handler getMHandler() {
        return this.f474967e;
    }

    public final m getProducer() {
        return this.f474966d;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f474967e = new b(this);
        View r101 = LayoutInflater.from(r100).inflate(R.layout.ttlive_assets_info_fragment, this, true);
        Intrinsics.checkNotNullParameter(r101, "view");
        RecyclerView r102 = (RecyclerView) r101.findViewById(R.id.assets_list);
        Context r103 = getContext();
        Intrinsics.checkNotNull(r103);
        this.f474963a = new AssetsInfoAdapter(r103);
        r102.setLayoutManager(new LinearLayoutManager(getContext()));
        r102.setAdapter(this.f474963a);
        this.f474965c = (TextView) r101.findViewById(R.id.assets_count);
        ((Button) r101.findViewById(R.id.close_asset_info)).setOnClickListener(new f02.b(r101));
        this.f474964b = (AssetsService) f.a(AssetsService.class);
        ((Button) r101.findViewById(R.id.clear_all_assets)).setOnClickListener(new c(this));
        AssetsInfoAdapter r104 = this.f474963a;
        List<Pair<e, Boolean>> r105 = null;
        if (r104 == null) goto L12;
        IAssetsManager r106 = this.f474964b;
        if (r106 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mAssetsManager");
    L7:
        LiveData<List<Pair<e, Boolean>>> r107 = r106.h0();
        if (r107 == null) goto L10;
        List<Pair<e, Boolean>> r108 = r107.getValue();
    L11:
        r104.y2(r108);
        goto L12
    L10:
        r108 = null;
    L12:
        AssetsInfoAdapter r109 = this.f474963a;
        if (r109 == null) goto L21;
        IAssetsManager r110 = this.f474964b;
        if (r110 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mAssetsManager");
    L17:
        LiveData<List<Pair<e, Boolean>>> r111 = r110.h0();
        if (r111 == null) goto L20;
        r105 = r111.getValue();
    L20:
        r109.y2(r105);
    L21:
        IAssetsManager r112 = this.f474964b;
        if (r112 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mAssetsManager");
    L24:
        LiveData<List<Pair<e, Boolean>>> r113 = r112.h0();
        if (r113 == null) goto L27;
        r113.observeForever(new d(this));
    L27:
        this.f474967e.sendEmptyMessageDelayed(0, 2000);
    }

    public final void setAdapter(AssetsInfoAdapter r100) {
        this.f474963a = r100;
    }

    public final void setMAssetsManager(IAssetsManager r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f474964b = r100;
    }

    public final void setMCount(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f474965c = r100;
    }

    public final void setMHandler(Handler r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f474967e = r100;
    }

    public final void setProducer(m r100) {
        this.f474966d = r100;
    }
}
