package qn0;

import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import sn0.l;
import sn0.m;

/* JADX INFO: loaded from: classes46.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f534005a = 0;

    public static final class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashMap<String, HashMap<String, String>> f534006a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap<String, String> f534007b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final rn0.a f534008c;

        @Override // sn0.m
        public final l a(l r100) {
            return new qn0.a(this, r100);
        }

        public a(HashMap r100, HashMap r101, rn0.b r102) {
            Intrinsics.checkNotNullParameter(r100, "offsetLayoutConfigMap");
            Intrinsics.checkNotNullParameter(r101, "offsetUIFeatureMap");
            Intrinsics.checkNotNullParameter(r102, ShortVideoSegments.KEY_PROP_PROVIDER);
            this.f534006a = r100;
            this.f534007b = r101;
            this.f534008c = r102;
        }
    }

    public static final class b implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashMap<String, HashMap<String, String>> f534009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap<String, String> f534010b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final rn0.a f534011c;

        @Override // sn0.m
        public final l a(l r100) {
            return new h(this, r100);
        }

        public b(HashMap r100, HashMap r101, rn0.b r102) {
            Intrinsics.checkNotNullParameter(r100, "offsetLayoutConfigMap");
            Intrinsics.checkNotNullParameter(r101, "offsetUIFeatureMap");
            Intrinsics.checkNotNullParameter(r102, ShortVideoSegments.KEY_PROP_PROVIDER);
            this.f534009a = r100;
            this.f534010b = r101;
            this.f534011c = r102;
        }
    }

    public static final class c implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashMap<String, LayoutConfigModel> f534012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final rn0.a f534013b;

        @Override // sn0.m
        public final l a(l r100) {
            return new j(this);
        }

        public c(HashMap r100, rn0.b r101) {
            Intrinsics.checkNotNullParameter(r100, "updateOffsetLayoutConfigToCacheMap");
            Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
            this.f534012a = r100;
            this.f534013b = r101;
        }
    }

    static {
    }
}
