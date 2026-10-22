package com.bytedance.ee.bear.list.sort;

import android.text.TextUtils;
import com.bytedance.ee.bear.list.recent.RecentSort;
import com.bytedance.ee.bear.sheet.exportimage.exportshare.ExportShareModel;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00010B=\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010.\u001a\u00020/2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dj\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-¨\u00061"}, d2 = {"Lcom/bytedance/ee/bear/list/sort/FilterType;", "", "resId", "", ResourceData.KEY_TYPE, "fileType", "", "forbiddenFileType", "reportType", "forbiddenSortResId", "<init>", "(Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getResId", "()I", "setResId", "(I)V", "getType", "setType", "getFileType", "()Ljava/lang/String;", "setFileType", "(Ljava/lang/String;)V", "getForbiddenFileType", "setForbiddenFileType", "getReportType", "setReportType", "getForbiddenSortResId", "()Ljava/lang/Integer;", "setForbiddenSortResId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "ALL", "DOC", "SHEET", "BITABLE", "SLIDES", "MINDNOTE", "FILE", "PHOTO", "WIKI", "FOLDER", "AI_NOTE_ALL", "AI_NOTE_MEETING_NOTE", "AI_NOTE_MONTHLY_SUMMARY", "AI_NOTE_WEEKLY_RECAP", "AI_NOTE_RECORD_NOTE", "isSame", "", "Companion", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FilterType extends Enum<FilterType> {
    public static final FilterType AI_NOTE_ALL = null;
    public static final FilterType AI_NOTE_MEETING_NOTE = null;
    public static final FilterType AI_NOTE_MONTHLY_SUMMARY = null;
    public static final FilterType AI_NOTE_RECORD_NOTE = null;
    public static final FilterType AI_NOTE_WEEKLY_RECAP = null;
    public static final FilterType ALL = null;
    public static final FilterType BITABLE = null;
    public static final a Companion = null;
    public static final FilterType DOC = null;
    public static final FilterType FILE = null;
    public static final FilterType FOLDER = null;
    public static final FilterType MINDNOTE = null;
    public static final FilterType PHOTO = null;
    public static final FilterType SHEET = null;
    public static final FilterType SLIDES = null;
    public static final FilterType WIKI = null;
    public static final /* synthetic */ FilterType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private String fileType;
    private String forbiddenFileType;
    private Integer forbiddenSortResId;
    private String reportType;
    private int resId;
    private int type;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static FilterType a(int r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "fileType");
            Intrinsics.checkNotNullParameter(r5, "forbiddenFileType");
            FilterType r0 = FilterType.AI_NOTE_ALL;
            if (r0.isSame(r3, r4, r5) == true) goto L19;
            FilterType r1 = FilterType.AI_NOTE_MEETING_NOTE;
            if (r1.isSame(r3, r4, r5) == true) goto L17;
            r1 = FilterType.AI_NOTE_MONTHLY_SUMMARY;
            if (r1.isSame(r3, r4, r5) == true) goto L17;
            r1 = FilterType.AI_NOTE_WEEKLY_RECAP;
            if (r1.isSame(r3, r4, r5) == true) goto L17;
            r1 = FilterType.AI_NOTE_RECORD_NOTE;
            if (r1.isSame(r3, r4, r5) == true) goto L17;
            return r0;
        L17:
            return r1;
        L19:
            return r0;
        }

        @JvmStatic
        public static FilterType b(int r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "fileType");
            Intrinsics.checkNotNullParameter(r5, "forbiddenFileType");
            Intrinsics.checkNotNullParameter(r4, "fileType");
            Intrinsics.checkNotNullParameter(r5, "forbiddenFileType");
            FilterType r0 = FilterType.PHOTO;
            if (r0.isSame(r3, r4, r5) == true) goto L5;
            FilterType r1 = FilterType.DOC;
            if (r1.isSame(r3, r4, r5) == true) goto L47;
            r1 = FilterType.SHEET;
            if (r1.isSame(r3, r4, r5) == true) goto L47;
            r1 = FilterType.BITABLE;
            if (r1.isSame(r3, r4, r5) == true) goto L47;
            r1 = FilterType.MINDNOTE;
            if (r1.isSame(r3, r4, r5) == true) goto L47;
            r1 = FilterType.FILE;
            if (r1.isSame(r3, r4, r5) == true) goto L47;
            if (r0.isSame(r3, r4, r5) == true) goto L48;
            FilterType r2 = FilterType.WIKI;
            if (r2.isSame(r3, r4, r5) == true) goto L49;
            FilterType r6 = FilterType.SLIDES;
            if (r6.isSame(r3, r4, r5) == true) goto L50;
            FilterType r7 = FilterType.AI_NOTE_ALL;
            if (r7.isSame(r3, r4, r5) == true) goto L51;
            FilterType r8 = FilterType.AI_NOTE_MEETING_NOTE;
            if (r8.isSame(r3, r4, r5) == true) goto L52;
            FilterType r9 = FilterType.AI_NOTE_MONTHLY_SUMMARY;
            if (r9.isSame(r3, r4, r5) == true) goto L53;
            FilterType r10 = FilterType.AI_NOTE_WEEKLY_RECAP;
            if (r10.isSame(r3, r4, r5) == true) goto L54;
            FilterType r11 = FilterType.AI_NOTE_RECORD_NOTE;
            if (r11.isSame(r3, r4, r5) == false) goto L46;
            return r11;
        L46:
            return FilterType.ALL;
        L54:
            return r10;
        L53:
            return r9;
        L52:
            return r8;
        L51:
            return r7;
        L50:
            return r6;
        L49:
            return r2;
        L48:
            return r0;
        L47:
            return r1;
        L5:
            return FilterType.ALL;
        }
    }

    @JvmStatic
    public static final FilterType getAINoteFilterByType(int r1, String r2, String r3) {
        Companion.getClass();
        return a.a(r1, r2, r3);
    }

    public static EnumEntries<FilterType> getEntries() {
        return b;
    }

    @JvmStatic
    public static final FilterType getFilterByType(int r1, String r2, String r3) {
        Companion.getClass();
        return a.b(r1, r2, r3);
    }

    static {
        FilterType r11 = new FilterType("ALL", 0, 2131887910, sbb.e.e.b, "", "", "all", null, 32, null);
        ALL = r11;
        Integer r20 = null;
        int r21 = 32;
        DefaultConstructorMarker r22 = null;
        FilterType r0 = new FilterType("DOC", 1, 2131887745, sbb.e.g.b, "", "", "docs", r20, r21, r22);
        DOC = r0;
        Integer r31 = null;
        int r32 = 32;
        DefaultConstructorMarker r33 = null;
        FilterType r1 = new FilterType("SHEET", 2, 2131887733, sbb.e.h.b, "", "", "sheets", r31, r32, r33);
        SHEET = r1;
        FilterType r2 = new FilterType("BITABLE", 3, 2131887715, sbb.e.i.b, "", "", DocumentType.BITABLE_NAME, r20, r21, r22);
        BITABLE = r2;
        FilterType r3 = new FilterType("SLIDES", 4, 2131889761, sbb.e.m.b, "", "", "slides", r31, r32, r33);
        SLIDES = r3;
        FilterType r4 = new FilterType("MINDNOTE", 5, 2131887774, sbb.e.k.b, "", "", "mindnotes", r20, r21, r22);
        MINDNOTE = r4;
        sbb.e r6 = sbb.e.l;
        FilterType r5 = new FilterType("FILE", 6, 2131889109, r6.b, "", "photo", DocumentType.VALUE_DRIVE, r31, r32, r33);
        FILE = r5;
        FilterType r7 = new FilterType("PHOTO", 7, 2131887914, r6.b, "photo", "", ExportShareModel.EXPORT_SHARE_TYPE_IMAGE, r20, r21, r22);
        PHOTO = r7;
        FilterType r8 = new FilterType("WIKI", 8, 2131887849, sbb.e.n.b, "", "", DocumentType.WIKI_NAME, Integer.valueOf(RecentSort.MODIFIED.getResId()));
        WIKI = r8;
        FilterType r9 = new FilterType("FOLDER", 9, 2131887757, sbb.e.f.b, "", "", DocumentType.FOLDER_NAME, r20, r21, r22);
        FOLDER = r9;
        sbb.e r10 = sbb.e.o;
        FilterType r12 = new FilterType("AI_NOTE_ALL", 10, 2131888700, r10.b, "all_ai_notes", "", "ai_notes_all", null, r32, r33);
        AI_NOTE_ALL = r12;
        FilterType r13 = new FilterType("AI_NOTE_MEETING_NOTE", 11, 2131888701, r10.b, "meeting_notes", "", "ai_notes_meeting", null, 32, null);
        AI_NOTE_MEETING_NOTE = r13;
        FilterType r14 = new FilterType("AI_NOTE_MONTHLY_SUMMARY", 12, 2131888702, r10.b, "monthly_summary", "", "ai_notes_monthly", null, 32, null);
        AI_NOTE_MONTHLY_SUMMARY = r14;
        FilterType r15 = new FilterType("AI_NOTE_WEEKLY_RECAP", 13, 2131888709, r10.b, "weekly_recap", "", "ai_notes_weekly", null, 32, null);
        AI_NOTE_WEEKLY_RECAP = r15;
        FilterType r16 = new FilterType("AI_NOTE_RECORD_NOTE", 14, 2131889714, r10.b, "record_notes", "", "ai_notes_record", null, 32, null);
        AI_NOTE_RECORD_NOTE = r16;
        FilterType[] r17 = {r11, r0, r1, r2, r3, r4, r5, r7, r8, r9, r12, r13, r14, r15, r16};
        a = r17;
        b = EnumEntriesKt.enumEntries(r17);
        Companion = new a();
    }

    public static FilterType[] values() {
        return (FilterType[]) a.clone();
    }

    public final String getFileType() {
        return this.fileType;
    }

    public final String getForbiddenFileType() {
        return this.forbiddenFileType;
    }

    public final Integer getForbiddenSortResId() {
        return this.forbiddenSortResId;
    }

    public final String getReportType() {
        return this.reportType;
    }

    public final int getResId() {
        return this.resId;
    }

    public final int getType() {
        return this.type;
    }

    public static FilterType valueOf(String r1) {
        return (FilterType) r27.a.a(FilterType.class, r1);
    }

    public final void setFileType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.fileType = r2;
    }

    public final void setForbiddenFileType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.forbiddenFileType = r2;
    }

    public final void setForbiddenSortResId(Integer r1) {
        this.forbiddenSortResId = r1;
    }

    public final void setReportType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.reportType = r2;
    }

    public final void setResId(int r1) {
        this.resId = r1;
    }

    public final void setType(int r1) {
        this.type = r1;
    }

    @JvmStatic
    public static final boolean isPhotoV2(int r1, String r2, String r3) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r2, "fileType");
        Intrinsics.checkNotNullParameter(r3, "forbiddenFileType");
        return PHOTO.isSame(r1, r2, r3);
    }

    public final boolean isSame(int r3, String r4, String r5) {
        if (this.type == r3) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r4) == false) goto L11;
        if (TextUtils.isEmpty(r5) == false) goto L11;
        return true;
    L11:
        if (TextUtils.isEmpty(r4) == true) goto L16;
        if (TextUtils.equals(this.fileType, r4) == false) goto L16;
        return true;
    L16:
        if (TextUtils.isEmpty(r5) == false) goto L18;
    L20:
        return false;
    L18:
        if (TextUtils.equals(this.forbiddenFileType, r5) == false) goto L20;
        return true;
    }

    public FilterType(String r1, int r2, int r3, int r4, String r5, String r6, String r7, Integer r8) {
        super(r1, r2);
        this.resId = r3;
        this.type = r4;
        this.fileType = r5;
        this.forbiddenFileType = r6;
        this.reportType = r7;
        this.forbiddenSortResId = r8;
    }

    public /* synthetic */ FilterType(String r11, int r12, int r13, int r14, String r15, String r16, String r17, Integer r18, int r19, DefaultConstructorMarker r20) {
        if ((r19 & 32) == 0) goto L5;
        Integer r9 = 0;
    L6:
        this(r11, r12, r13, r14, r15, r16, r17, r9);
        return;
    L5:
        r9 = r18;
        goto L6
    }
}
