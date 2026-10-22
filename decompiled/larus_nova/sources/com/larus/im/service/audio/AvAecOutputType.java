package com.larus.im.service.audio;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/im/service/audio/AvAecOutputType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "AecMono", "AecStereo", "MicAndAec", "Companion", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AvAecOutputType extends Enum<AvAecOutputType> {
    public static final AvAecOutputType AecMono = null;
    public static final AvAecOutputType AecStereo = null;
    public static final a Companion = null;
    public static final AvAecOutputType MicAndAec = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AvAecOutputType[] f350629a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350630b = null;
    private final int type;

    public static final class a {
        public a() {
        }

        public static AvAecOutputType a(int r100) {
            AvAecOutputType[] r101 = AvAecOutputType.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L11;
            AvAecOutputType r104 = r101[r103];
            if (r104.getType() != r100) goto L7;
            boolean r105 = true;
        L8:
            if (r105 == true) goto L12;
            r103 = r103 + 1;
        L12:
            if (r104 == null) goto L14;
            return r104;
        L14:
            return AvAecOutputType.AecMono;
        L7:
            r105 = false;
            goto L8
        L11:
            r104 = null;
            goto L12
        }
    }

    public static EnumEntries<AvAecOutputType> getEntries() {
        return f350630b;
    }

    static {
        AvAecOutputType r100 = new AvAecOutputType("AecMono", 0, 0);
        AecMono = r100;
        AvAecOutputType r101 = new AvAecOutputType("AecStereo", 1, 1);
        AecStereo = r101;
        AvAecOutputType r102 = new AvAecOutputType("MicAndAec", 2, 2);
        MicAndAec = r102;
        AvAecOutputType[] r103 = {r100, r101, r102};
        f350629a = r103;
        f350630b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static AvAecOutputType[] values() {
        return (AvAecOutputType[]) f350629a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static AvAecOutputType valueOf(String r100) {
        return (AvAecOutputType) r27.a.a(AvAecOutputType.class, r100);
    }

    public AvAecOutputType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
