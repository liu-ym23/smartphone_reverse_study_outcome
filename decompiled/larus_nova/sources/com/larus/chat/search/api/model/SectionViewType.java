package com.larus.chat.search.api.model;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/larus/chat/search/api/model/SectionViewType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "EMPTY", EffectConstants.NORMAL, "TIME", "LAST", "EXTERNAL", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SectionViewType extends Enum<SectionViewType> {
    public static final a Companion = null;
    public static final SectionViewType EMPTY = null;
    public static final SectionViewType EXTERNAL = null;
    public static final SectionViewType LAST = null;
    public static final SectionViewType NORMAL = null;
    public static final SectionViewType TIME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SectionViewType[] f325445a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f325446b = null;
    private final int type;

    public static final class a {
        public a() {
        }

        public static SectionViewType a(int r100) {
            SectionViewType[] r101 = SectionViewType.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L11;
            SectionViewType r104 = r101[r103];
            if (r104.getType() != r100) goto L7;
            boolean r105 = true;
        L8:
            if (r105 == true) goto L12;
            r103 = r103 + 1;
        L12:
            if (r104 == null) goto L14;
            return r104;
        L14:
            return SectionViewType.EMPTY;
        L7:
            r105 = false;
            goto L8
        L11:
            r104 = null;
            goto L12
        }
    }

    public static EnumEntries<SectionViewType> getEntries() {
        return f325446b;
    }

    static {
        SectionViewType r100 = new SectionViewType("EMPTY", 0, -1);
        EMPTY = r100;
        SectionViewType r101 = new SectionViewType(EffectConstants.NORMAL, 1, 0);
        NORMAL = r101;
        SectionViewType r102 = new SectionViewType("TIME", 2, 1);
        TIME = r102;
        SectionViewType r103 = new SectionViewType("LAST", 3, 2);
        LAST = r103;
        SectionViewType r104 = new SectionViewType("EXTERNAL", 4, 3);
        EXTERNAL = r104;
        SectionViewType[] r105 = {r100, r101, r102, r103, r104};
        f325445a = r105;
        f325446b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static SectionViewType[] values() {
        return (SectionViewType[]) f325445a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static SectionViewType valueOf(String r100) {
        return (SectionViewType) r27.a.a(SectionViewType.class, r100);
    }

    public SectionViewType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
