package com.bytedance.badger.module;

import android.content.Context;
import com.bytedance.badger.Badger;
import com.bytedance.badger.data.BadgerResult;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
public abstract class BadgerModuleBase {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/badger/module/BadgerModuleBase$BadgerRequestData;", "", "token", "", "(J)V", "getToken", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "badger-api_release"}, k = 1, mv = {1, 1, 15})
    public static final class BadgerRequestData {
        private final long token;

        public static /* synthetic */ BadgerRequestData copy$default(BadgerRequestData r100, long r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.token;
        L6:
            return r100.copy(r101);
        }

        public final long component1() {
            return this.token;
        }

        public final BadgerRequestData copy(long r100) {
            return new BadgerRequestData(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L5;
        L13:
            return true;
        L5:
            if ((r100 instanceof BadgerRequestData) == true) goto L7;
        L12:
            return false;
        L7:
            if (this.token != ((BadgerRequestData) r100).token) goto L9;
            boolean r101 = true;
        L10:
            if (r101 == false) goto L12;
        L9:
            r101 = false;
            goto L10
        }

        public int hashCode() {
            long r100 = this.token;
            return (int) (r100 ^ (r100 >>> 32));
        }

        public String toString() {
            return "BadgerRequestData(token=" + this.token + ")";
        }

        public final long getToken() {
            return this.token;
        }

        public BadgerRequestData(long r100) {
            this.token = r100;
        }
    }

    public BadgerModuleBase() {
    }

    public abstract BadgerResult a(Context r100, BadgerRequestData r101);

    public final BadgerResult execute(String r110, long r111) {
        System.nanoTime();
        Context r100 = Badger.INSTANCE.getContext();
        return a(r100, new BadgerRequestData(r111));
    L5:
        th = move-exception;
        Badger.INSTANCE.log(6, "BadgerModuleBase", "execute error", th);     // Catch: Throwable -> L8
    L9:
        StringBuilder r112 = new StringBuilder();
        r112.append(th.getClass().getName());
        r112.append(": ");
        String r101 = th.getMessage();
        if (r101 == null) goto L18;
        String r102 = StringsKt.replace$default(r101, "\n", " ", false, 4, null);
        if (r102 == null) goto L18;
        String r113 = StringsKt.replace$default(r102, "\"", "'", false, 4, null);
        if (r113 == null) goto L18;
        if (r113.length() <= 256) goto L19;
        r113 = r113.substring(0, 256);
    L19:
        r112.append(r113);
        return new BadgerResult.Failure(-1000, r112.toString());
    L18:
        r113 = null;
        goto L19
    }
}
