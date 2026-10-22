package com.larus.camera.api.params;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0002\u0016\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/larus/camera/api/params/CameraResultRoute;", "Ljava/io/Serializable;", "ownerNodeId", "", "delivery", "Lcom/larus/camera/api/params/CameraResultRoute$Delivery;", "<init>", "(Ljava/lang/String;Lcom/larus/camera/api/params/CameraResultRoute$Delivery;)V", "getOwnerNodeId", "()Ljava/lang/String;", "getDelivery", "()Lcom/larus/camera/api/params/CameraResultRoute$Delivery;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Delivery", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraResultRoute implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;
    private final Delivery delivery;
    private final String ownerNodeId;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/camera/api/params/CameraResultRoute$Delivery;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", "CONFIRM_TO_OWNER", "PREVIEW_CAPTURE_APPEND", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Delivery extends Enum<Delivery> implements Serializable {
        public static final Delivery CONFIRM_TO_OWNER = null;
        public static final Delivery PREVIEW_CAPTURE_APPEND = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Delivery[] f321458a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f321459b = null;

        public static EnumEntries<Delivery> getEntries() {
            return f321459b;
        }

        static {
            Delivery r100 = new Delivery("CONFIRM_TO_OWNER", 0);
            CONFIRM_TO_OWNER = r100;
            Delivery r101 = new Delivery("PREVIEW_CAPTURE_APPEND", 1);
            PREVIEW_CAPTURE_APPEND = r101;
            Delivery[] r102 = {r100, r101};
            f321458a = r102;
            f321459b = EnumEntriesKt.enumEntries(r102);
        }

        public static Delivery[] values() {
            return (Delivery[]) f321458a.clone();
        }

        public static Delivery valueOf(String r100) {
            return (Delivery) r27.a.a(Delivery.class, r100);
        }

        public Delivery(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ CameraResultRoute copy$default(CameraResultRoute r100, String r101, Delivery r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.ownerNodeId;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.delivery;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.ownerNodeId;
    }

    public final Delivery component2() {
        return this.delivery;
    }

    public final CameraResultRoute copy(String r100, Delivery r101) {
        Intrinsics.checkNotNullParameter(r100, "ownerNodeId");
        Intrinsics.checkNotNullParameter(r101, "delivery");
        return new CameraResultRoute(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CameraResultRoute) == true) goto L8;
        return false;
    L8:
        CameraResultRoute r101 = (CameraResultRoute) r100;
        if (Intrinsics.areEqual(this.ownerNodeId, r101.ownerNodeId) == true) goto L12;
        return false;
    L12:
        if (this.delivery == r101.delivery) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.ownerNodeId.hashCode() * 31) + this.delivery.hashCode();
    }

    public String toString() {
        return "CameraResultRoute(ownerNodeId=" + this.ownerNodeId + ", delivery=" + this.delivery + ')';
    }

    public final Delivery getDelivery() {
        return this.delivery;
    }

    public final String getOwnerNodeId() {
        return this.ownerNodeId;
    }

    public CameraResultRoute(String r100, Delivery r101) {
        Intrinsics.checkNotNullParameter(r100, "ownerNodeId");
        Intrinsics.checkNotNullParameter(r101, "delivery");
        this.ownerNodeId = r100;
        this.delivery = r101;
    }
}
