package com.bytedance.live.richcontent;

import ek6.b;
import ek6.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final class ResourceInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f255740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f255741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public State f255742c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/live/richcontent/ResourceInfo$State;", "", "READY", "SUCCESS", "FAILED", "richcontent_release"}, k = 1, mv = {1, 4, 2})
    public static final enum State extends Enum<State> {
        public static final State FAILED = null;
        public static final State READY = null;
        public static final State SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f255743a = null;

        static {
            State r100 = new State("READY", 0);
            READY = r100;
            State r101 = new State("SUCCESS", 1);
            SUCCESS = r101;
            State r102 = new State("FAILED", 2);
            FAILED = r102;
            f255743a = new State[]{r100, r101, r102};
        }

        public static State valueOf(String r100) {
            return (State) a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f255743a.clone();
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ResourceInfo) == false) goto L12;
        ResourceInfo r101 = (ResourceInfo) r100;
        if (Intrinsics.areEqual(this.f255740a, r101.f255740a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f255741b, r101.f255741b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f255742c, r101.f255742c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        b r100 = this.f255740a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        d r104 = this.f255741b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        State r107 = this.f255742c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ResourceInfo(resource=" + this.f255740a + ", content=" + this.f255741b + ", state=" + this.f255742c + ")";
    }

    public ResourceInfo(b r100, d r101) {
        State r102 = State.READY;
        Intrinsics.checkNotNullParameter(r100, "resource");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r102, "state");
        this.f255740a = r100;
        this.f255741b = r101;
        this.f255742c = r102;
    }
}
