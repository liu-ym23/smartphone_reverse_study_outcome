package uk8;

import com.larus.bmhome.chat.standarduikit.elapsedblock.viewmodel.ElapsedBlockStatus;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f550555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f550556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f550557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ElapsedBlockStatus f550558d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ib8.c f550559e;

    /* JADX INFO: renamed from: uk8.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C7894a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f550560a = null;

        static {
            int[] r100 = new int[ElapsedBlockStatus.values().length];
            r100[ElapsedBlockStatus.Folded.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ElapsedBlockStatus.Expanded.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f550560a = r100;
        }
    }

    public a() {
        this.f550558d = ElapsedBlockStatus.Folded;
        this.f550559e = new ib8.c(true, null, null, 14);
    }
}
