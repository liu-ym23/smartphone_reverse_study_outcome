package com.larus.network;

import androidx.lifecycle.MutableLiveData;
import com.byted.cast.common.bean.State;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class NetConnectionTypeProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static NetworkStatus f360084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final NetworkStatus[] f360085b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MutableLiveData<NetworkStatus> f360086c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CopyOnWriteArrayList<k> f360087d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final n f360088e = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/network/NetConnectionTypeProvider$NetworkStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FAKE", "UNKNOWN", State.DISCONNECTED, "POOR_2G", "GOOD_2G", "NORMAL_3G", "POOR_4G", "NORMAL_4G", "GOOD_4G", "EXCELLENT_4G", "network_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum NetworkStatus extends Enum<NetworkStatus> {
        public static final NetworkStatus DISCONNECTED = null;
        public static final NetworkStatus EXCELLENT_4G = null;
        public static final NetworkStatus FAKE = null;
        public static final NetworkStatus GOOD_2G = null;
        public static final NetworkStatus GOOD_4G = null;
        public static final NetworkStatus NORMAL_3G = null;
        public static final NetworkStatus NORMAL_4G = null;
        public static final NetworkStatus POOR_2G = null;
        public static final NetworkStatus POOR_4G = null;
        public static final NetworkStatus UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ NetworkStatus[] f360089a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f360090b = null;
        private final int value;

        public static EnumEntries<NetworkStatus> getEntries() {
            return f360090b;
        }

        static {
            NetworkStatus r100 = new NetworkStatus("FAKE", 0, -1);
            FAKE = r100;
            NetworkStatus r101 = new NetworkStatus("UNKNOWN", 1, 0);
            UNKNOWN = r101;
            NetworkStatus r102 = new NetworkStatus(State.DISCONNECTED, 2, 1);
            DISCONNECTED = r102;
            NetworkStatus r103 = new NetworkStatus("POOR_2G", 3, 2);
            POOR_2G = r103;
            NetworkStatus r104 = new NetworkStatus("GOOD_2G", 4, 3);
            GOOD_2G = r104;
            NetworkStatus r105 = new NetworkStatus("NORMAL_3G", 5, 4);
            NORMAL_3G = r105;
            NetworkStatus r110 = new NetworkStatus("POOR_4G", 6, 5);
            POOR_4G = r110;
            NetworkStatus r111 = new NetworkStatus("NORMAL_4G", 7, 6);
            NORMAL_4G = r111;
            NetworkStatus r112 = new NetworkStatus("GOOD_4G", 8, 7);
            GOOD_4G = r112;
            NetworkStatus r113 = new NetworkStatus("EXCELLENT_4G", 9, 8);
            EXCELLENT_4G = r113;
            NetworkStatus[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
            f360089a = r114;
            f360090b = EnumEntriesKt.enumEntries(r114);
        }

        public static NetworkStatus[] values() {
            return (NetworkStatus[]) f360089a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static NetworkStatus valueOf(String r100) {
            return (NetworkStatus) r27.a.a(NetworkStatus.class, r100);
        }

        public NetworkStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f360091a = null;

        static {
            int[] r100 = new int[NetworkStatus.values().length];
            r100[NetworkStatus.FAKE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[NetworkStatus.UNKNOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[NetworkStatus.DISCONNECTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[NetworkStatus.POOR_2G.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[NetworkStatus.GOOD_2G.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f360091a = r100;
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.network.n] */
    static {
        f360084a = NetworkStatus.NORMAL_4G;
        f360085b = NetworkStatus.values();
        f360086c = new MutableLiveData();
        f360087d = new CopyOnWriteArrayList();
        f360088e = new n();
    }

    public static NetworkQualityType a(NetworkStatus r100) {
        int r101 = a.f360091a[r100.ordinal()];
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L15;
        if (r101 == 3) goto L15;
        if (r101 == 4) goto L17;
        if (r101 == 5) goto L17;
        return NetworkQualityType.NORMAL_NETWORK;
    L17:
        return NetworkQualityType.WEAK_NETWORK;
    L15:
        return NetworkQualityType.NO_NET;
    }
}
