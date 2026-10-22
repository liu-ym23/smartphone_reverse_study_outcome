package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/relax/relaxframework/AnimaxEventKey;", "", "", "value", "I", "getValue", "()I", "AnimaxReady", "AnimaxCompletion", "AnimaxStart", "AnimaxRepeat", "AnimaxCancel", "AnimaxUpdate", "AnimaxError", "AnimaxFPS", "AnimaxFirstFrame", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum AnimaxEventKey extends Enum<AnimaxEventKey> {
    public static final AnimaxEventKey AnimaxCancel = null;
    public static final AnimaxEventKey AnimaxCompletion = null;
    public static final AnimaxEventKey AnimaxError = null;
    public static final AnimaxEventKey AnimaxFPS = null;
    public static final AnimaxEventKey AnimaxFirstFrame = null;
    public static final AnimaxEventKey AnimaxReady = null;
    public static final AnimaxEventKey AnimaxRepeat = null;
    public static final AnimaxEventKey AnimaxStart = null;
    public static final AnimaxEventKey AnimaxUpdate = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnimaxEventKey[] f404672a = null;
    private final int value;

    public static AnimaxEventKey valueOf(String r100) {
        return (AnimaxEventKey) r27.a.a(AnimaxEventKey.class, r100);
    }

    public static AnimaxEventKey[] values() {
        return (AnimaxEventKey[]) f404672a.clone();
    }

    static {
        AnimaxEventKey r100 = new AnimaxEventKey("AnimaxReady", 0, 30129);
        AnimaxReady = r100;
        AnimaxEventKey r101 = new AnimaxEventKey("AnimaxCompletion", 1, 30130);
        AnimaxCompletion = r101;
        AnimaxEventKey r102 = new AnimaxEventKey("AnimaxStart", 2, 30131);
        AnimaxStart = r102;
        AnimaxEventKey r103 = new AnimaxEventKey("AnimaxRepeat", 3, 30132);
        AnimaxRepeat = r103;
        AnimaxEventKey r104 = new AnimaxEventKey("AnimaxCancel", 4, 30133);
        AnimaxCancel = r104;
        AnimaxEventKey r105 = new AnimaxEventKey("AnimaxUpdate", 5, 30134);
        AnimaxUpdate = r105;
        AnimaxEventKey r110 = new AnimaxEventKey("AnimaxError", 6, 30135);
        AnimaxError = r110;
        AnimaxEventKey r111 = new AnimaxEventKey("AnimaxFPS", 7, 30136);
        AnimaxFPS = r111;
        AnimaxEventKey r112 = new AnimaxEventKey("AnimaxFirstFrame", 8, 30137);
        AnimaxFirstFrame = r112;
        f404672a = new AnimaxEventKey[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public final int getValue() {
        return this.value;
    }

    public AnimaxEventKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
