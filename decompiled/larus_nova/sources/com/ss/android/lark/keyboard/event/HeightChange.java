package com.ss.android.lark.keyboard.event;

/* JADX INFO: loaded from: classes36.dex */
public class HeightChange implements q, s.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Factory f429287b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f429288a;

    public static final class Factory extends s<HeightChange> {
        public Factory() {
            super(AnonymousClass1.INSTANCE);
        }
    }

    static {
        f429287b = new Factory();
    }

    public HeightChange() {
    }

    @Override // com.ss.android.lark.keyboard.event.c
    public final String getTag() {
        return "HeightChange {" + this.f429288a + '}';
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.ss.android.lark.keyboard.event.s.b
    public final void recycle() {
        Factory r100 = f429287b;
        if (r100.f429315b.size() >= 3) goto L6;
        r100.f429315b.add((T) this);
        return;
    }
}
