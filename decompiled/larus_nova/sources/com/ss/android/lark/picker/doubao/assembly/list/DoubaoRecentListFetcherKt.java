package com.ss.android.lark.picker.doubao.assembly.list;

import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.lark.pb.basic.v1.Doc;
import com.ss.android.lark.picker.base.PickerRecentSpaceInfo;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import com.ss.android.lark.search.dto.info.SearchWikiInfo;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0002\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0002\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002\u001a%\u0010\u000b\u001a\u00020\f2\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000f0\u000e\"\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"toSearchBaseInfoOrNull", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "Lcom/bytedance/ee/bear/list/dto/Document;", "toSpaceInfo", "Lcom/ss/android/lark/search/dto/info/SearchSpaceInfo;", "toWikiInfo", "Lcom/ss/android/lark/search/dto/info/SearchWikiInfo;", "mapDocumentTypeToPbDocType", "Lcom/bytedance/lark/pb/basic/v1/Doc$Type;", "typeValue", "", "parseTimeSec", "", "candidates", "", "", "([Ljava/lang/String;)J", "picker-doubao-assembly_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DoubaoRecentListFetcherKt {
    public static final /* synthetic */ SearchBaseInfo access$toSearchBaseInfoOrNull(Document r100) {
        return toSearchBaseInfoOrNull(r100);
    }

    private static final Doc.Type mapDocumentTypeToPbDocType(int r100) {
        if (r100 == 0) goto L35;
        if (r100 == 8) goto L46;
        if (r100 == 16) goto L45;
        if (r100 == 22) goto L44;
        if (r100 == 25) goto L43;
        if (r100 == 30) goto L42;
        if (r100 == 111) goto L41;
        if (r100 == 2) goto L40;
        if (r100 == 3) goto L39;
        if (r100 == 11) goto L38;
        if (r100 == 12) goto L37;
        return Doc.Type.UNKNOWN;
    L37:
        return Doc.Type.FILE;
    L38:
        return Doc.Type.MINDNOTE;
    L39:
        return Doc.Type.SHEET;
    L40:
        return Doc.Type.DOC;
    L41:
        return Doc.Type.WIKI;
    L42:
        return Doc.Type.SLIDES;
    L43:
        return Doc.Type.SHORTCUT;
    L44:
        return Doc.Type.DOCX;
    L45:
        return Doc.Type.WIKI;
    L46:
        return Doc.Type.BITABLE;
    L35:
        return Doc.Type.FOLDER;
    }

    private static final long parseTimeSec(String... r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L20;
        String r103 = r100[r102];
        if (r103 == null) goto L7;
        String r104 = StringsKt.trim(r103).toString();
    L8:
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        if (r104.length() != 0) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == true) goto L19;
        Long r106 = StringsKt.toLongOrNull(r104);
        if (r106 == null) goto L19;
        return r106.longValue();
    L19:
        r102 = r102 + 1;
        goto L3
    L13:
        r105 = false;
        goto L14
    L7:
        r104 = null;
        goto L8
    L20:
        return 0;
    }

    private static final SearchBaseInfo toSearchBaseInfoOrNull(Document r100) {
        int r101 = r100.getType();
        if (r101 == 16) goto L8;
        if (r101 == 111) goto L8;
        return toSpaceInfo(r100);
    L8:
        return toWikiInfo(r100);
    }

    private static final SearchSpaceInfo toSpaceInfo(Document r100) {
        int r101 = r100.getType();
        String r102 = r100.f227872c;
        String r103 = "";
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        String r104 = r100.f227873d;
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        String r105 = r100.f227891p;
        if (r105 != null) goto L11;
        r105 = "";
    L11:
        String r106 = r100.f227868a;
        if (r106 != null) goto L14;
        r106 = "";
    L14:
        String r107 = r100.F2;
        if (r107 == null) goto L18;
        r103 = r107;
    L18:
        long r108 = parseTimeSec(new String[]{r100.f227887l});
        PickerRecentSpaceInfo r109 = new PickerRecentSpaceInfo();
        r109.originalDocType = r101;
        if (StringsKt.isBlank(r102) == false) goto L21;
        r102 = r104;
    L21:
        r109.setId(r102);
        r109.setTitle(r106);
        r109.setFileType(String.valueOf(r101));
        r109.setDocType(mapDocumentTypeToPbDocType(r101));
        r109.setDocUrl(r105);
        r109.setToken(r104);
        r109.setIconInfo(r103);
        r109.setIsShareFolder(r109.getIsShareFolder());
        r109.setUpdateTime(r108);
        r109.setLastOpenTime(r108);
        return r109;
    }

    private static final SearchWikiInfo toWikiInfo(Document r110) {
        String r100 = r110.f227872c;
        String r101 = "";
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        String r102 = r110.f227873d;
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        String r103 = r110.f227891p;
        if (r103 != null) goto L11;
        r103 = "";
    L11:
        String r104 = r110.f227868a;
        if (r104 != null) goto L14;
        r104 = "";
    L14:
        String r105 = r110.F2;
        if (r105 != null) goto L17;
        r105 = "";
    L17:
        String r106 = r110.G1;
        if (r106 == null) goto L21;
        r101 = r106;
    L21:
        long r107 = parseTimeSec(new String[]{r110.f227887l});
        int r108 = r110.f227908y1;
        if (r108 > 0) goto L25;
        r108 = r110.getType();
    L25:
        SearchWikiInfo r109 = new SearchWikiInfo();
        if (StringsKt.isBlank(r100) == true) goto L28;
        String r111 = r100;
    L32:
        r109.setId(r111);
        r109.setTitle(r104);
        r109.setUrl(r103);
        r109.setToken(r100);
        PickerRecentSpaceInfo r112 = new PickerRecentSpaceInfo();
        r112.originalDocType = r108;
        r112.originalRealType = r110.f227908y1;
        if (StringsKt.isBlank(r101) == true) goto L35;
        r102 = r101;
    L38:
        r112.setId(r102);
        r112.setTitle(r104);
        r112.setFileType(String.valueOf(r108));
        r112.setDocType(mapDocumentTypeToPbDocType(r108));
        r112.setDocUrl(r103);
        if (StringsKt.isBlank(r101) == true) goto L42;
        r100 = r101;
    L42:
        r112.setToken(r100);
        r112.setIconInfo(r105);
        r112.setIsShareFolder(Boolean.valueOf(r110.P1));
        r112.setUpdateTime(r107);
        r109.setSpaceInfo(r112);
        return r109;
    L35:
        if (StringsKt.isBlank(r102) == false) goto L38;
        r102 = r103;
        goto L38
    L28:
        if (StringsKt.isBlank(r102) == false) goto L30;
        r111 = r103;
        goto L32
    L30:
        r111 = r102;
        goto L32
    }
}
