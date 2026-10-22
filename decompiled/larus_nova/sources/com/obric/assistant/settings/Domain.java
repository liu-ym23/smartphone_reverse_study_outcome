package com.obric.assistant.settings;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0013\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/settings/Domain;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "SearchContact", "SearchCallHistory", "SearchSms", "SearchPhoto", "SearchAlbum", "SearchNote", "SearchAlarm", "SearchCountdown", "SearchAssistantMemory", "SearchFile", "SearchRecord", "SearchCalendar", "SearchLifeLog", "getName", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Domain extends Enum<Domain> {
    public static final a Companion = null;
    public static final Domain SearchAlarm = null;
    public static final Domain SearchAlbum = null;
    public static final Domain SearchAssistantMemory = null;
    public static final Domain SearchCalendar = null;
    public static final Domain SearchCallHistory = null;
    public static final Domain SearchContact = null;
    public static final Domain SearchCountdown = null;
    public static final Domain SearchFile = null;
    public static final Domain SearchLifeLog = null;
    public static final Domain SearchNote = null;
    public static final Domain SearchPhoto = null;
    public static final Domain SearchRecord = null;
    public static final Domain SearchSms = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Domain[] f391697a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f391698b = null;
    private final String value;

    public static final class a {
        public a() {
        }

        public static Domain a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "name");
            switch(r100.hashCode()) {
                case -2010021952: goto L54;
                case -1520294546: goto L50;
                case -1514691255: goto L46;
                case -1227990728: goto L42;
                case -512803215: goto L38;
                case 241710137: goto L34;
                case 976120102: goto L30;
                case 1042782871: goto L26;
                case 1100682601: goto L22;
                case 1100683655: goto L18;
                case 1114429770: goto L14;
                case 1282578276: goto L10;
                case 1282822618: goto L6;
                default: goto L57;
            };
        L57:
            return null;
        L6:
            if (r100.equals("SearchNote") == false) goto L57;
            return Domain.SearchNote;
        L10:
            if (r100.equals("SearchFile") == false) goto L57;
            return Domain.SearchFile;
        L14:
            if (r100.equals("SearchPhoto") == false) goto L57;
            return Domain.SearchPhoto;
        L18:
            if (r100.equals("SearchAlbum") == false) goto L57;
            return Domain.SearchAlbum;
        L22:
            if (r100.equals("SearchAlarm") == false) goto L57;
            return Domain.SearchAlarm;
        L26:
            if (r100.equals("SearchAssistantMemory") == false) goto L57;
            return Domain.SearchAssistantMemory;
        L30:
            if (r100.equals("SearchCalendar") == false) goto L57;
            return Domain.SearchCalendar;
        L34:
            if (r100.equals("SearchRecord") == false) goto L57;
            return Domain.SearchRecord;
        L38:
            if (r100.equals("SearchSms") == false) goto L57;
            return Domain.SearchSms;
        L42:
            if (r100.equals("SearchContact") == false) goto L57;
            return Domain.SearchContact;
        L46:
            if (r100.equals("SearchCountdown") == false) goto L57;
            return Domain.SearchCountdown;
        L50:
            if (r100.equals("SearchCallHistory") == false) goto L57;
            return Domain.SearchCallHistory;
        L54:
            if (r100.equals("SearchLifeLog") == false) goto L57;
            return Domain.SearchLifeLog;
        }
    }

    public static EnumEntries<Domain> getEntries() {
        return f391698b;
    }

    static {
        Domain r100 = new Domain("SearchContact", 0, "SearchContact");
        SearchContact = r100;
        Domain r101 = new Domain("SearchCallHistory", 1, "SearchCallHistory");
        SearchCallHistory = r101;
        Domain r102 = new Domain("SearchSms", 2, "SearchSms");
        SearchSms = r102;
        Domain r103 = new Domain("SearchPhoto", 3, "SearchPhoto");
        SearchPhoto = r103;
        Domain r104 = new Domain("SearchAlbum", 4, "SearchAlbum");
        SearchAlbum = r104;
        Domain r105 = new Domain("SearchNote", 5, "SearchNote");
        SearchNote = r105;
        Domain r110 = new Domain("SearchAlarm", 6, "SearchAlarm");
        SearchAlarm = r110;
        Domain r111 = new Domain("SearchCountdown", 7, "SearchCountdown");
        SearchCountdown = r111;
        Domain r112 = new Domain("SearchAssistantMemory", 8, "SearchAssistantMemory");
        SearchAssistantMemory = r112;
        Domain r113 = new Domain("SearchFile", 9, "SearchFile");
        SearchFile = r113;
        Domain r114 = new Domain("SearchRecord", 10, "SearchRecord");
        SearchRecord = r114;
        Domain r115 = new Domain("SearchCalendar", 11, "SearchCalendar");
        SearchCalendar = r115;
        Domain r106 = new Domain("SearchLifeLog", 12, "SearchLifeLog");
        SearchLifeLog = r106;
        Domain[] r107 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
        f391697a = r107;
        f391698b = EnumEntriesKt.enumEntries(r107);
        Companion = new a();
    }

    public static Domain[] values() {
        return (Domain[]) f391697a.clone();
    }

    public final String getName() {
        return this.value;
    }

    public static Domain valueOf(String r100) {
        return (Domain) r27.a.a(Domain.class, r100);
    }

    public Domain(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
