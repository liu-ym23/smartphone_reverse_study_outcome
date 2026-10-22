package com.bytedance.ee.bear.list.sort;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.bytedance.ee.bear.list.recent.RecentSort;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.bmhome.chat.bean.SuggestActionType;
import com.larus.nova.R;
import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00010B=\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010.\u001a\u00020/2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dj\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-¨\u00061"}, d2 = {"Lcom/bytedance/ee/bear/list/sort/FilterType;", "", "resId", "", "type", "fileType", "", "forbiddenFileType", "reportType", "forbiddenSortResId", "<init>", "(Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getResId", "()I", "setResId", "(I)V", "getType", "setType", "getFileType", "()Ljava/lang/String;", "setFileType", "(Ljava/lang/String;)V", "getForbiddenFileType", "setForbiddenFileType", "getReportType", "setReportType", "getForbiddenSortResId", "()Ljava/lang/Integer;", "setForbiddenSortResId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", AccountType.ALL, PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "SHEET", "BITABLE", "SLIDES", PreloadConfigModel.VERSION_CHECK_TYPE_MINDNOTE, "FILE", SuggestActionType.PHOTO, "WIKI", "FOLDER", "AI_NOTE_ALL", "AI_NOTE_MEETING_NOTE", "AI_NOTE_MONTHLY_SUMMARY", "AI_NOTE_WEEKLY_RECAP", "AI_NOTE_RECORD_NOTE", "isSame", "", "Companion", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FilterType[] f229627a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f229628b = null;
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
        public static FilterType a(int r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "fileType");
            Intrinsics.checkNotNullParameter(r102, "forbiddenFileType");
            FilterType r103 = FilterType.AI_NOTE_ALL;
            if (r103.isSame(r100, r101, r102) == true) goto L19;
            FilterType r104 = FilterType.AI_NOTE_MEETING_NOTE;
            if (r104.isSame(r100, r101, r102) == true) goto L17;
            r104 = FilterType.AI_NOTE_MONTHLY_SUMMARY;
            if (r104.isSame(r100, r101, r102) == true) goto L17;
            r104 = FilterType.AI_NOTE_WEEKLY_RECAP;
            if (r104.isSame(r100, r101, r102) == true) goto L17;
            r104 = FilterType.AI_NOTE_RECORD_NOTE;
            if (r104.isSame(r100, r101, r102) == true) goto L17;
            return r103;
        L17:
            return r104;
        L19:
            return r103;
        }

        @JvmStatic
        public static FilterType b(int r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "fileType");
            Intrinsics.checkNotNullParameter(r102, "forbiddenFileType");
            Intrinsics.checkNotNullParameter(r101, "fileType");
            Intrinsics.checkNotNullParameter(r102, "forbiddenFileType");
            FilterType r103 = FilterType.PHOTO;
            if (r103.isSame(r100, r101, r102) == true) goto L5;
            FilterType r104 = FilterType.DOC;
            if (r104.isSame(r100, r101, r102) == true) goto L47;
            r104 = FilterType.SHEET;
            if (r104.isSame(r100, r101, r102) == true) goto L47;
            r104 = FilterType.BITABLE;
            if (r104.isSame(r100, r101, r102) == true) goto L47;
            r104 = FilterType.MINDNOTE;
            if (r104.isSame(r100, r101, r102) == true) goto L47;
            r104 = FilterType.FILE;
            if (r104.isSame(r100, r101, r102) == true) goto L47;
            if (r103.isSame(r100, r101, r102) == true) goto L48;
            FilterType r105 = FilterType.WIKI;
            if (r105.isSame(r100, r101, r102) == true) goto L49;
            FilterType r106 = FilterType.SLIDES;
            if (r106.isSame(r100, r101, r102) == true) goto L50;
            FilterType r107 = FilterType.AI_NOTE_ALL;
            if (r107.isSame(r100, r101, r102) == true) goto L51;
            FilterType r108 = FilterType.AI_NOTE_MEETING_NOTE;
            if (r108.isSame(r100, r101, r102) == true) goto L52;
            FilterType r109 = FilterType.AI_NOTE_MONTHLY_SUMMARY;
            if (r109.isSame(r100, r101, r102) == true) goto L53;
            FilterType r110 = FilterType.AI_NOTE_WEEKLY_RECAP;
            if (r110.isSame(r100, r101, r102) == true) goto L54;
            FilterType r111 = FilterType.AI_NOTE_RECORD_NOTE;
            if (r111.isSame(r100, r101, r102) == false) goto L46;
            return r111;
        L46:
            return FilterType.ALL;
        L54:
            return r110;
        L53:
            return r109;
        L52:
            return r108;
        L51:
            return r107;
        L50:
            return r106;
        L49:
            return r105;
        L48:
            return r103;
        L47:
            return r104;
        L5:
            return FilterType.ALL;
        }
    }

    @JvmStatic
    public static final FilterType getAINoteFilterByType(int r100, String r101, String r102) {
        Companion.getClass();
        return a.a(r100, r101, r102);
    }

    public static EnumEntries<FilterType> getEntries() {
        return f229628b;
    }

    @JvmStatic
    public static final FilterType getFilterByType(int r100, String r101, String r102) {
        Companion.getClass();
        return a.b(r100, r101, r102);
    }

    static {
        FilterType r110 = new FilterType(AccountType.ALL, 0, R.string.Doc_List_Filter_All, sbb.e.f541294e.f541317b, "", "", "all", null, 32, null);
        ALL = r110;
        Integer r210 = null;
        int r211 = 32;
        DefaultConstructorMarker r212 = null;
        FilterType r100 = new FilterType(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 1, R.string.Doc_Facade_Document, sbb.e.f541296g.f541317b, "", "", "docs", r210, r211, r212);
        DOC = r100;
        Integer r310 = null;
        int r311 = 32;
        DefaultConstructorMarker r312 = null;
        FilterType r101 = new FilterType("SHEET", 2, R.string.Doc_Facade_CreateSheet, sbb.e.f541297h.f541317b, "", "", "sheets", r310, r311, r312);
        SHEET = r101;
        FilterType r102 = new FilterType("BITABLE", 3, R.string.Doc_Facade_Bitable, sbb.e.f541298i.f541317b, "", "", DocumentType.BITABLE_NAME, r210, r211, r212);
        BITABLE = r102;
        FilterType r103 = new FilterType("SLIDES", 4, R.string.LarkCCM_Slides_Filter_Menu, sbb.e.f541302m.f541317b, "", "", "slides", r310, r311, r312);
        SLIDES = r103;
        FilterType r104 = new FilterType(PreloadConfigModel.VERSION_CHECK_TYPE_MINDNOTE, 5, R.string.Doc_Facade_MindNote, sbb.e.f541300k.f541317b, "", "", "mindnotes", r210, r211, r212);
        MINDNOTE = r104;
        int r213 = R.string.LarkCCM_Docs_LocalFile_Menu_Mob;
        sbb.e r105 = sbb.e.f541301l;
        FilterType r106 = new FilterType("FILE", 6, r213, r105.f541317b, "", "photo", "drive", r310, r311, r312);
        FILE = r106;
        FilterType r107 = new FilterType(SuggestActionType.PHOTO, 7, R.string.Doc_List_Filter_Image, r105.f541317b, "photo", "", "image", r210, r211, r212);
        PHOTO = r107;
        FilterType r108 = new FilterType("WIKI", 8, R.string.Doc_Facade_Wiki, sbb.e.f541303n.f541317b, "", "", "wiki", Integer.valueOf(RecentSort.MODIFIED.getResId()));
        WIKI = r108;
        FilterType r109 = new FilterType("FOLDER", 9, R.string.Doc_Facade_Folder, sbb.e.f541295f.f541317b, "", "", DocumentType.FOLDER_NAME, r210, r211, r212);
        FOLDER = r109;
        int r214 = R.string.LarkCCM_AINotes_AllAINotes_Option;
        sbb.e r111 = sbb.e.f541304o;
        FilterType r112 = new FilterType("AI_NOTE_ALL", 10, r214, r111.f541317b, "all_ai_notes", "", "ai_notes_all", null, r311, r312);
        AI_NOTE_ALL = r112;
        FilterType r113 = new FilterType("AI_NOTE_MEETING_NOTE", 11, R.string.LarkCCM_AINotes_MeetingNotes_Option, r111.f541317b, "meeting_notes", "", "ai_notes_meeting", null, 32, null);
        AI_NOTE_MEETING_NOTE = r113;
        FilterType r114 = new FilterType("AI_NOTE_MONTHLY_SUMMARY", 12, R.string.LarkCCM_AINotes_MonthlySummary_Option, r111.f541317b, "monthly_summary", "", "ai_notes_monthly", null, 32, null);
        AI_NOTE_MONTHLY_SUMMARY = r114;
        FilterType r115 = new FilterType("AI_NOTE_WEEKLY_RECAP", 13, R.string.LarkCCM_AINotes_WeeklyRecap_Option, r111.f541317b, "weekly_recap", "", "ai_notes_weekly", null, 32, null);
        AI_NOTE_WEEKLY_RECAP = r115;
        FilterType r116 = new FilterType("AI_NOTE_RECORD_NOTE", 14, R.string.LarkCCM_RecordNotes_FromRecordingUpload_Dropdown, r111.f541317b, "record_notes", "", "ai_notes_record", null, 32, null);
        AI_NOTE_RECORD_NOTE = r116;
        FilterType[] r117 = {r110, r100, r101, r102, r103, r104, r106, r107, r108, r109, r112, r113, r114, r115, r116};
        f229627a = r117;
        f229628b = EnumEntriesKt.enumEntries(r117);
        Companion = new a();
    }

    public static FilterType[] values() {
        return (FilterType[]) f229627a.clone();
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

    public static FilterType valueOf(String r100) {
        return (FilterType) r27.a.a(FilterType.class, r100);
    }

    public final void setFileType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fileType = r100;
    }

    public final void setForbiddenFileType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.forbiddenFileType = r100;
    }

    public final void setForbiddenSortResId(Integer r100) {
        this.forbiddenSortResId = r100;
    }

    public final void setReportType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.reportType = r100;
    }

    public final void setResId(int r100) {
        this.resId = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }

    @JvmStatic
    public static final boolean isPhotoV2(int r100, String r101, String r102) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r101, "fileType");
        Intrinsics.checkNotNullParameter(r102, "forbiddenFileType");
        return PHOTO.isSame(r100, r101, r102);
    }

    public final boolean isSame(int r100, String r101, String r102) {
        if (this.type == r100) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        if (TextUtils.isEmpty(r102) == false) goto L11;
        return true;
    L11:
        if (TextUtils.isEmpty(r101) == true) goto L16;
        if (TextUtils.equals(this.fileType, r101) == false) goto L16;
        return true;
    L16:
        if (TextUtils.isEmpty(r102) == false) goto L18;
    L20:
        return false;
    L18:
        if (TextUtils.equals(this.forbiddenFileType, r102) == false) goto L20;
        return true;
    }

    public FilterType(String r100, int r101, int r102, int r103, String r104, String r105, String r106, Integer r107) {
        super(r100, r101);
        this.resId = r102;
        this.type = r103;
        this.fileType = r104;
        this.forbiddenFileType = r105;
        this.reportType = r106;
        this.forbiddenSortResId = r107;
    }

    public /* synthetic */ FilterType(String r110, int r111, int r112, int r113, String r114, String r115, String r116, Integer r117, int r118, DefaultConstructorMarker r210) {
        if ((r118 & 32) == 0) goto L5;
        Integer r100 = 0;
    L6:
        this(r110, r111, r112, r113, r114, r115, r116, r100);
        return;
    L5:
        r100 = r117;
        goto L6
    }
}
