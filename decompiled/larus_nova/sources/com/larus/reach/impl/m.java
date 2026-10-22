package com.larus.reach.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f367216a;

    /* JADX INFO: loaded from: classes31.dex */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/larus/reach/impl/ReachNotifyParser$ReachFrontierEvent;", "", "cmdType", "", "reachNotify", "Lcom/larus/reach/api/ReachNotify;", "<init>", "(Ljava/lang/Integer;Lcom/larus/reach/api/ReachNotify;)V", "getCmdType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getReachNotify", "()Lcom/larus/reach/api/ReachNotify;", "component1", "component2", "copy", "(Ljava/lang/Integer;Lcom/larus/reach/api/ReachNotify;)Lcom/larus/reach/impl/ReachNotifyParser$ReachFrontierEvent;", "equals", "", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("cmd_type")
        private final Integer cmdType;

        @SerializedName("reach_notify")
        private final ns9.m reachNotify;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.cmdType, r101.cmdType) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.reachNotify, r101.reachNotify) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Integer r100 = this.cmdType;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            ns9.m r104 = this.reachNotify;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "ReachFrontierEvent(cmdType=" + this.cmdType + ", reachNotify=" + this.reachNotify + ')';
        }

        public a() {
            this.cmdType = null;
            this.reachNotify = null;
        }

        public final Integer a() {
            return this.cmdType;
        }

        public final ns9.m b() {
            return this.reachNotify;
        }
    }

    public m() {
        this.f367216a = new GsonBuilder().create();
    }
}
