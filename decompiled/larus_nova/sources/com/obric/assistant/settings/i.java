package com.obric.assistant.settings;

import android.os.Build;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class i {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f392081a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f392082b = null;

        static {
            int[] r100 = new int[ToggleName.values().length];
            r100[ToggleName.CONTACTS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L44
        L80:
            r100[ToggleName.CALL_LOGS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L45
        L90:
            r100[ToggleName.MESSAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L46
        L102:
            r100[ToggleName.ALBUM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L47
        L104:
            r100[ToggleName.NOTES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L48
        L110:
            r100[ToggleName.CLOCK.ordinal()] = 6;     // Catch: NoSuchFieldError -> L49
        L116:
            r100[ToggleName.GLOBAL_MEMORY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L50
        L72:
            r100[ToggleName.FILE_MANAGEMENT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L51
        L82:
            r100[ToggleName.RECORD.ordinal()] = 9;     // Catch: NoSuchFieldError -> L52
        L88:
            r100[ToggleName.CALENDAR.ordinal()] = 10;     // Catch: NoSuchFieldError -> L53
        L96:
            r100[ToggleName.AI_DIARY.ordinal()] = 11;     // Catch: NoSuchFieldError -> L54
        L112:
            r100[ToggleName.IMAGES.ordinal()] = 12;     // Catch: NoSuchFieldError -> L55
        L118:
            r100[ToggleName.VIDEO.ordinal()] = 13;     // Catch: NoSuchFieldError -> L56
        L28:
            f392081a = r100;
            int[] r101 = new int[Domain.values().length];
            r101[Domain.SearchContact.ordinal()] = 1;     // Catch: NoSuchFieldError -> L57
        L86:
            r101[Domain.SearchCallHistory.ordinal()] = 2;     // Catch: NoSuchFieldError -> L58
        L94:
            r101[Domain.SearchSms.ordinal()] = 3;     // Catch: NoSuchFieldError -> L59
        L100:
            r101[Domain.SearchPhoto.ordinal()] = 4;     // Catch: NoSuchFieldError -> L60
        L108:
            r101[Domain.SearchAlbum.ordinal()] = 5;     // Catch: NoSuchFieldError -> L61
        L114:
            r101[Domain.SearchNote.ordinal()] = 6;     // Catch: NoSuchFieldError -> L62
        L120:
            r101[Domain.SearchAlarm.ordinal()] = 7;     // Catch: NoSuchFieldError -> L63
        L70:
            r101[Domain.SearchCountdown.ordinal()] = 8;     // Catch: NoSuchFieldError -> L64
        L76:
            r101[Domain.SearchAssistantMemory.ordinal()] = 9;     // Catch: NoSuchFieldError -> L65
        L84:
            r101[Domain.SearchFile.ordinal()] = 10;     // Catch: NoSuchFieldError -> L66
        L92:
            r101[Domain.SearchRecord.ordinal()] = 11;     // Catch: NoSuchFieldError -> L67
        L98:
            r101[Domain.SearchCalendar.ordinal()] = 12;     // Catch: NoSuchFieldError -> L68
        L106:
            r101[Domain.SearchLifeLog.ordinal()] = 13;     // Catch: NoSuchFieldError -> L69
        L42:
            f392082b = r101;
        }
    }

    public static final List<String> a(ToggleName r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = a.f392081a[r100.ordinal()];
        if (r101 == 1) goto L41;
        if (r101 == 2) goto L54;
        if (r101 == 3) goto L53;
        if (r101 != 4) goto L11;
        int r102 = Build.VERSION.SDK_INT;
        if (r102 >= 34) goto L50;
        if (r102 < 33) goto L52;
        return CollectionsKt.listOf(new String[]{BaseConstants.PERMISSION_READ_MEDIA_IMAGES, BaseConstants.PERMISSION_READ_MEDIA_VIDEO});
    L52:
        return CollectionsKt.emptyList();
    L50:
        return CollectionsKt.listOf(new String[]{"android.permission.READ_MEDIA_VISUAL_USER_SELECTED", BaseConstants.PERMISSION_READ_MEDIA_IMAGES, BaseConstants.PERMISSION_READ_MEDIA_VIDEO});
    L11:
        if (r101 == 8) goto L29;
        if (r101 == 10) goto L47;
        if (r101 == 12) goto L24;
        if (r101 == 13) goto L20;
        return CollectionsKt.emptyList();
    L20:
        if (Build.VERSION.SDK_INT < 33) goto L44;
        return CollectionsKt.listOf(BaseConstants.PERMISSION_READ_MEDIA_VIDEO);
    L44:
        return CollectionsKt.emptyList();
    L24:
        if (Build.VERSION.SDK_INT < 33) goto L46;
        return CollectionsKt.listOf(BaseConstants.PERMISSION_READ_MEDIA_IMAGES);
    L46:
        return CollectionsKt.emptyList();
    L47:
        return CollectionsKt.listOf("android.permission.READ_CALENDAR");
    L29:
        if (Build.VERSION.SDK_INT < 30) goto L49;
        return CollectionsKt.listOf("android.permission.MANAGE_EXTERNAL_STORAGE");
    L49:
        return CollectionsKt.emptyList();
    L53:
        return CollectionsKt.listOf("android.permission.READ_SMS");
    L54:
        return CollectionsKt.listOf("android.permission.READ_CALL_LOG");
    L41:
        return CollectionsKt.listOf("android.permission.READ_CONTACTS");
    }

    public static final ToggleName b(Domain r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        switch(a.f392082b[r100.ordinal()]) {
            case 1: goto L17;
            case 2: goto L27;
            case 3: goto L26;
            case 4: goto L25;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L23;
            case 8: goto L23;
            case 9: goto L22;
            case 10: goto L21;
            case 11: goto L20;
            case 12: goto L19;
            case 13: goto L18;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L18:
        return ToggleName.AI_DIARY;
    L19:
        return ToggleName.CALENDAR;
    L20:
        return ToggleName.RECORD;
    L21:
        return ToggleName.FILE_MANAGEMENT;
    L22:
        return ToggleName.GLOBAL_MEMORY;
    L23:
        return ToggleName.CLOCK;
    L24:
        return ToggleName.NOTES;
    L25:
        return ToggleName.ALBUM;
    L26:
        return ToggleName.MESSAGE;
    L27:
        return ToggleName.CALL_LOGS;
    L17:
        return ToggleName.CONTACTS;
    }
}
