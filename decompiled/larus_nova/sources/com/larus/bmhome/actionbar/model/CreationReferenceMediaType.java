package com.larus.bmhome.actionbar.model;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/actionbar/model/CreationReferenceMediaType;", "", "wireValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getWireValue", "()Ljava/lang/String;", "IMAGE", "VIDEO", "AUDIO", "Companion", "instruction_core_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreationReferenceMediaType extends Enum<CreationReferenceMediaType> {
    public static final CreationReferenceMediaType AUDIO = null;
    public static final a Companion = null;
    public static final CreationReferenceMediaType IMAGE = null;
    public static final CreationReferenceMediaType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CreationReferenceMediaType[] f294936a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f294937b = null;
    private final String wireValue;

    public static final class a {
        public a() {
        }

        public static CreationReferenceMediaType a(String r100) {
            if (r100 == null) goto L7;
            String r101 = StringsKt.trim(r100).toString();
            if (r101 == null) goto L7;
            String r102 = r101.toLowerCase(Locale.ROOT);
        L8:
            CreationReferenceMediaType[] r103 = CreationReferenceMediaType.values();
            int r104 = r103.length;
            int r105 = 0;
        L9:
            if (r105 >= r104) goto L17;
            CreationReferenceMediaType r106 = r103[r105];
            if (Intrinsics.areEqual(r106.getWireValue(), r102) == true) goto L14;
            r105 = r105 + 1;
            goto L9
        L14:
            return r106;
        L17:
            return null;
        L7:
            r102 = null;
            goto L8
        }
    }

    public static EnumEntries<CreationReferenceMediaType> getEntries() {
        return f294937b;
    }

    static {
        CreationReferenceMediaType r100 = new CreationReferenceMediaType("IMAGE", 0, "image");
        IMAGE = r100;
        CreationReferenceMediaType r101 = new CreationReferenceMediaType("VIDEO", 1, "video");
        VIDEO = r101;
        CreationReferenceMediaType r102 = new CreationReferenceMediaType("AUDIO", 2, "audio");
        AUDIO = r102;
        CreationReferenceMediaType[] r103 = {r100, r101, r102};
        f294936a = r103;
        f294937b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static CreationReferenceMediaType[] values() {
        return (CreationReferenceMediaType[]) f294936a.clone();
    }

    public final String getWireValue() {
        return this.wireValue;
    }

    public static CreationReferenceMediaType valueOf(String r100) {
        return (CreationReferenceMediaType) r27.a.a(CreationReferenceMediaType.class, r100);
    }

    public CreationReferenceMediaType(String r100, int r101, String r102) {
        super(r100, r101);
        this.wireValue = r102;
    }
}
