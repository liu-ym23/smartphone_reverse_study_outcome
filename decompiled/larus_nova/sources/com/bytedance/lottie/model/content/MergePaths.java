package com.bytedance.lottie.model.content;

import com.bytedance.lottie.LottieDrawable;
import com.bytedance.lottie.c;
import nz6.k;
import sz6.b;

/* JADX INFO: loaded from: classes21.dex */
public final class MergePaths implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MergePathsMode f264460a;

    public static final enum MergePathsMode extends Enum<MergePathsMode> {
        public static final MergePathsMode Add = null;
        public static final MergePathsMode ExcludeIntersections = null;
        public static final MergePathsMode Intersect = null;
        public static final MergePathsMode Merge = null;
        public static final MergePathsMode Subtract = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MergePathsMode[] f264461a = null;

        static {
            MergePathsMode r100 = new MergePathsMode("Merge", 0);
            Merge = r100;
            MergePathsMode r101 = new MergePathsMode("Add", 1);
            Add = r101;
            MergePathsMode r102 = new MergePathsMode("Subtract", 2);
            Subtract = r102;
            MergePathsMode r103 = new MergePathsMode("Intersect", 3);
            Intersect = r103;
            MergePathsMode r104 = new MergePathsMode("ExcludeIntersections", 4);
            ExcludeIntersections = r104;
            f264461a = new MergePathsMode[]{r100, r101, r102, r103, r104};
        }

        public static MergePathsMode[] values() {
            return (MergePathsMode[]) f264461a.clone();
        }

        public static MergePathsMode forId(int r100) {
            if (r100 == 1) goto L23;
            if (r100 == 2) goto L21;
            if (r100 == 3) goto L19;
            if (r100 == 4) goto L17;
            if (r100 == 5) goto L15;
            return Merge;
        L15:
            return ExcludeIntersections;
        L17:
            return Intersect;
        L19:
            return Subtract;
        L21:
            return Add;
        L23:
            return Merge;
        }

        public static MergePathsMode valueOf(String r100) {
            return (MergePathsMode) r27.a.a(MergePathsMode.class, r100);
        }

        public MergePathsMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final String toString() {
        return "MergePaths{mode=" + this.f264460a + '}';
    }

    public MergePaths(String r100, MergePathsMode r101) {
        this.f264460a = r101;
    }

    @Override // sz6.b
    public final nz6.b a(LottieDrawable r100, com.bytedance.lottie.model.layer.a r101) {
        if (r100.f264401i == true) goto L7;
        c.b("Animation contains merge paths but they are disabled.");
        return null;
    L7:
        return new k(this);
    }
}
