package sn0;

import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f542642a = 0;

    public static final class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<pn0.a> f542643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final rn0.a f542644b;

        @Override // sn0.m
        public final l a(l r100) {
            return new sn0.b(this, r100);
        }

        public a(List r100, rn0.b r101) {
            Intrinsics.checkNotNullParameter(r100, "geckoLayoutConfigReviewList");
            Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
            this.f542643a = r100;
            this.f542644b = r101;
        }
    }

    public static final class b implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<pn0.a> f542645a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final rn0.a f542646b;

        @Override // sn0.m
        public final l a(l r100) {
            return new i(this, r100);
        }

        public b(List r100, rn0.b r101) {
            Intrinsics.checkNotNullParameter(r100, "localAssetsEntranceList");
            Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
            this.f542645a = r100;
            this.f542646b = r101;
        }
    }

    public static final class c implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashMap<String, LayoutConfigModel> f542647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final rn0.a f542648b;

        @Override // sn0.m
        public final l a(l r100) {
            return new k(this);
        }

        public c(HashMap r100, rn0.b r101) {
            Intrinsics.checkNotNullParameter(r100, "layoutConfigResMap");
            Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
            this.f542647a = r100;
            this.f542648b = r101;
        }
    }

    static {
    }
}
