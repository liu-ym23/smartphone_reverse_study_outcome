package com.bytedance.ee.bear.contract;

import androidx.lifecycle.LiveData;
import java.util.Objects;

/* JADX INFO: loaded from: classes16.dex */
public interface ConnectionService {

    public static class NetworkState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f216895a;

        public @interface NetworkType {
        }

        public final boolean a() {
            if (this.f216895a == 6) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean b() {
            int r100 = this.f216895a;
            if (r100 >= 2) goto L5;
        L7:
            return false;
        L5:
            if (r100 > 5) goto L7;
            return true;
        }

        public final boolean c() {
            if (this.f216895a == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public final int hashCode() {
            return Objects.hashCode(Integer.valueOf(this.f216895a));
        }

        public final String toString() {
            return "NetworkState{type=" + this.f216895a + '}';
        }

        public int getType() {
            return this.f216895a;
        }

        public NetworkState(int r100) {
            this.f216895a = r100;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof NetworkState) == true) goto L9;
            return false;
        L9:
            if (this.f216895a == ((NetworkState) r100).f216895a) goto L13;
            return false;
        L13:
            return true;
        }
    }

    LiveData<NetworkState> a();

    NetworkState getNetworkState();
}
