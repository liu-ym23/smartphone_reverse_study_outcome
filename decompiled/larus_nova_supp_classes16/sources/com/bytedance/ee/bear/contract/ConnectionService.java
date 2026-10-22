package com.bytedance.ee.bear.contract;

import androidx.lifecycle.LiveData;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface ConnectionService {

    public static class NetworkState {
        public final int a;

        public @interface NetworkType {
        }

        public final boolean a() {
            if (this.a == 6) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean b() {
            int r0 = this.a;
            if (r0 >= 2) goto L5;
        L7:
            return false;
        L5:
            if (r0 > 5) goto L7;
            return true;
        }

        public final boolean c() {
            if (this.a == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public final int hashCode() {
            return Objects.hashCode(Integer.valueOf(this.a));
        }

        public final String toString() {
            return "NetworkState{type=" + this.a + '}';
        }

        public int getType() {
            return this.a;
        }

        public NetworkState(int r1) {
            this.a = r1;
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof NetworkState) == true) goto L9;
            return false;
        L9:
            if (this.a == ((NetworkState) r4).a) goto L13;
            return false;
        L13:
            return true;
        }
    }

    LiveData<NetworkState> a();

    NetworkState getNetworkState();
}
