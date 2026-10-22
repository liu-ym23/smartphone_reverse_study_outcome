package com.larksuite.component.card.resources;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class CardResource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ResourceType f283903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f283904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f283905c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/component/card/resources/CardResource$ResourceType;", "", "<init>", "(Ljava/lang/String;I)V", "AUDIO", "VIDEO", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ResourceType extends Enum<ResourceType> {
        public static final ResourceType AUDIO = null;
        public static final ResourceType VIDEO = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ResourceType[] f283906a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f283907b = null;

        public static EnumEntries<ResourceType> getEntries() {
            return f283907b;
        }

        static {
            ResourceType r100 = new ResourceType("AUDIO", 0);
            AUDIO = r100;
            ResourceType r101 = new ResourceType("VIDEO", 1);
            VIDEO = r101;
            ResourceType[] r102 = {r100, r101};
            f283906a = r102;
            f283907b = EnumEntriesKt.enumEntries(r102);
        }

        public static ResourceType[] values() {
            return (ResourceType[]) f283906a.clone();
        }

        public static ResourceType valueOf(String r100) {
            return (ResourceType) r27.a.a(ResourceType.class, r100);
        }

        public ResourceType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CardResource) == true) goto L8;
        return false;
    L8:
        CardResource r101 = (CardResource) r100;
        if (this.f283903a == r101.f283903a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f283904b, r101.f283904b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f283905c, r101.f283905c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f283903a.hashCode() * 31) + this.f283904b.hashCode()) * 31) + this.f283905c.hashCode();
    }

    public final String toString() {
        return "CardResource(type=" + this.f283903a + ", fileKey=" + this.f283904b + ", path=" + this.f283905c + ')';
    }

    public final ResourceType getType() {
        return this.f283903a;
    }

    public CardResource(ResourceType r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "fileKey");
        Intrinsics.checkNotNullParameter(r102, "path");
        this.f283903a = r100;
        this.f283904b = r101;
        this.f283905c = r102;
    }
}
