package com.ss.android.lark.search.dto.info;

import com.ss.android.lark.search.dto.constant.SearchCommonConstants;
import com.ss.android.lark.search.dto.constant.SearchInsideTarget;

/* JADX INFO: loaded from: classes38.dex */
public class SearchMoreInfo extends SearchBaseInfo {
    private String mAppId;
    private boolean mHasMore;
    public SearchInsideTarget target;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f440163a = null;

        static {
            int[] r100 = new int[SearchInsideTarget.values().length];
            f440163a = r100;
            r100[SearchInsideTarget.APP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L28:
            f440163a[SearchInsideTarget.CHAT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L34:
            f440163a[SearchInsideTarget.DOC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L46:
            f440163a[SearchInsideTarget.WIKI.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L30:
            f440163a[SearchInsideTarget.MESSAGE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L36:
            f440163a[SearchInsideTarget.CONTACTS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L40:
            f440163a[SearchInsideTarget.CALENDAR.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L42:
            f440163a[SearchInsideTarget.MAIL.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L26:
            f440163a[SearchInsideTarget.ONCALL.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L32:
            f440163a[SearchInsideTarget.OPEN_SEARCH.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L38:
            f440163a[SearchInsideTarget.SLASH_COMMAND.ordinal()] = 11;     // Catch: NoSuchFieldError -> L25
            return;
        }
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getResultTypeForReport() {
        return "more_results";
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getTagForReport() {
        switch(a.f440163a[this.target.ordinal()]) {
            case 1: goto L22;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L18;
            case 5: goto L16;
            case 6: goto L14;
            case 7: goto L12;
            case 8: goto L10;
            case 9: goto L8;
            case 10: goto L6;
            case 11: goto L6;
            default: goto L4;
        };
    L4:
        return "";
    L6:
        return "slash_command_section";
    L8:
        return "helpdesk_section";
    L10:
        return "emails_section";
    L12:
        return "calendar_section";
    L14:
        return "contacts_section";
    L16:
        return "messages_section";
    L18:
        return "docs_section";
    L20:
        return "groups_section";
    L22:
        return "apps_section";
    }

    public SearchMoreInfo() {
        this.mAppId = null;
        this.target = SearchInsideTarget.QUICK_JUMP;
        this.type = SearchCommonConstants.SearchResultType.SHOW_MORE;
    }

    public String getAppId() {
        return this.mAppId;
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setAppId(String r100) {
        this.mAppId = r100;
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public void setHasMore(boolean r100) {
        this.mHasMore = r100;
    }
}
