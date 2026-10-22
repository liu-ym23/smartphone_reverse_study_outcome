package com.bytedance.ee.docsdk.impl.base;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/base/DocumentType;", "", "value", "", "type", "", "pathType", "(ILjava/lang/String;Ljava/lang/String;)V", "getPathType", "()Ljava/lang/String;", "setPathType", "(Ljava/lang/String;)V", "getValue", "()I", "equals", "", "o", "hashCode", "Companion", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DocumentType {
    public static final DocumentType BASE_ADD = null;
    public static final String BASE_ADD_NAME = "baseAdd";
    public static final String BASE_ADD_PATH_NAME = "base/add";
    public static final int BASE_ADD_VALUE = 84;
    public static final DocumentType BITABLE = null;
    public static final DocumentType BITABLE_FORM = null;
    public static final String BITABLE_FORM_NAME = "form";
    public static final int BITABLE_FORM_VALUE = 80;
    public static final String BITABLE_NAME = "bitable";
    public static final int BITABLE_VALUE = 8;
    public static final Companion Companion = null;
    public static final DocumentType DOC = null;
    public static final DocumentType DOCX = null;
    public static final String DOCX_NAME = "docx";
    public static final DocumentType DOCX_SYNC_BLOCK = null;
    public static final String DOCX_SYNC_BLOCK_NAME = "sync";
    public static final int DOCX_SYNC_BLOCK_VALUE = 44;
    public static final int DOCX_VALUE = 22;
    public static final DocumentType DOCX_WHITE_BOARD = null;
    public static final String DOCX_WHITE_BOARD_NAME = "whiteboard";
    public static final int DOCX_WHITE_BOARD_VALUE = 38;
    public static final String DOC_NAME = "doc";
    public static final int DOC_VALUE = 2;
    private static List<String> DOC_WEBVIEW_SUPPORT_TYPE_NAMES = null;
    public static final DocumentType FILE = null;
    public static final String FILE_NAME = "file";
    public static final int FILE_VALUE = 12;
    public static final DocumentType FOLDER = null;
    public static final String FOLDER_NAME = "folder";
    public static final int FOLDER_VALUE = 0;
    public static final DocumentType IM_FILE = null;
    public static final String IM_FILE_NAME = "im_file";
    public static final int IM_FILE_VALUE = 998;
    public static final DocumentType MINDNOTE = null;
    public static final String MINDNOTE_NAME = "mindnote";
    public static final int MINDNOTE_VALUE = 11;
    public static final DocumentType MINUTES = null;
    public static final String MINUTES_NAME = "minutes";
    public static final int MINUTES_VALUE = 28;
    public static final DocumentType OPEN_PLATFORM = null;
    public static final String OPEN_PLATFORM_NAME = "open_platform";
    public static final int OPEN_PLATFORM_VALUE = 200;
    public static final DocumentType SHEET = null;
    public static final String SHEET_NAME = "sheet";
    public static final int SHEET_VALUE = 3;
    public static final int SHORTCUT_VALUE = 25;
    public static final DocumentType SLIDES = null;
    public static final String SLIDES_NAME = "slides";
    public static final int SLIDES_VALUE = 30;
    private static Integer[] SUPPORT_FILE_TYPE_VALUES = null;
    public static final DocumentType UNKNOWN = null;
    public static final String UNKNOWN_NAME = "unknown";
    public static final int UNKNOWN_VALUE = -1;
    public static final String VALUE_DRIVE = "drive";
    public static final DocumentType WIKI = null;
    public static final DocumentType WIKI_FOLDER = null;
    public static final String WIKI_FOLDER_NAME = "catalog";
    public static final int WIKI_FOLDER_VALUE = 111;
    public static final String WIKI_NAME = "wiki";
    public static final int WIKI_VALUE = 16;
    private String pathType;
    public final String type;
    private final int value;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010!\n\u0002\b\u001e\n\u0002\u0010\u0011\n\u0002\b\u0018\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010L\u001a\u00020\u00062\b\u0010M\u001a\u0004\u0018\u00010\u0006J\u000e\u0010N\u001a\u00020\u00062\u0006\u0010M\u001a\u00020\tJ\u000e\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\tJ\u0010\u0010O\u001a\u00020\u00042\b\u0010Q\u001a\u0004\u0018\u00010\u0006J\u000e\u0010R\u001a\u00020\u00062\u0006\u0010M\u001a\u00020\tJ\u0012\u0010S\u001a\u00020\t2\b\u0010M\u001a\u0004\u0018\u00010\u0006H\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\"\u0010;\u001a\b\u0012\u0004\u0012\u00020\t0<X\u0086\u000e¢\u0006\u0010\n\u0002\u0010A\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0010\u0010B\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/base/DocumentType$Companion;", "", "()V", "BASE_ADD", "Lcom/bytedance/ee/docsdk/impl/base/DocumentType;", "BASE_ADD_NAME", "", "BASE_ADD_PATH_NAME", "BASE_ADD_VALUE", "", "BITABLE", "BITABLE_FORM", "BITABLE_FORM_NAME", "BITABLE_FORM_VALUE", "BITABLE_NAME", "BITABLE_VALUE", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, "DOCX_NAME", "DOCX_SYNC_BLOCK", "DOCX_SYNC_BLOCK_NAME", "DOCX_SYNC_BLOCK_VALUE", "DOCX_VALUE", "DOCX_WHITE_BOARD", "DOCX_WHITE_BOARD_NAME", "DOCX_WHITE_BOARD_VALUE", "DOC_NAME", "DOC_VALUE", "DOC_WEBVIEW_SUPPORT_TYPE_NAMES", "", "getDOC_WEBVIEW_SUPPORT_TYPE_NAMES", "()Ljava/util/List;", "setDOC_WEBVIEW_SUPPORT_TYPE_NAMES", "(Ljava/util/List;)V", "FILE", "FILE_NAME", "FILE_VALUE", "FOLDER", "FOLDER_NAME", "FOLDER_VALUE", "IM_FILE", "IM_FILE_NAME", "IM_FILE_VALUE", PreloadConfigModel.VERSION_CHECK_TYPE_MINDNOTE, "MINDNOTE_NAME", "MINDNOTE_VALUE", "MINUTES", "MINUTES_NAME", "MINUTES_VALUE", "OPEN_PLATFORM", "OPEN_PLATFORM_NAME", "OPEN_PLATFORM_VALUE", "SHEET", "SHEET_NAME", "SHEET_VALUE", "SHORTCUT_VALUE", "SLIDES", "SLIDES_NAME", "SLIDES_VALUE", "SUPPORT_FILE_TYPE_VALUES", "", "getSUPPORT_FILE_TYPE_VALUES", "()[Ljava/lang/Integer;", "setSUPPORT_FILE_TYPE_VALUES", "([Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "UNKNOWN", "UNKNOWN_NAME", "UNKNOWN_VALUE", "VALUE_DRIVE", "WIKI", "WIKI_FOLDER", "WIKI_FOLDER_NAME", "WIKI_FOLDER_VALUE", "WIKI_NAME", "WIKI_VALUE", "getDocumentPathType", "type", "getDocumentReportTypeString", "getDocumentType", "typeValue", "typeName", "getDocumentTypeString", "getDocumentTypeValue", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final List<String> getDOC_WEBVIEW_SUPPORT_TYPE_NAMES() {
            return DocumentType.access$getDOC_WEBVIEW_SUPPORT_TYPE_NAMES$cp();
        }

        public final Integer[] getSUPPORT_FILE_TYPE_VALUES() {
            return DocumentType.access$getSUPPORT_FILE_TYPE_VALUES$cp();
        }

        public final String getDocumentPathType(String r100) {
            String r101 = DocumentType.UNKNOWN.getPathType();
            DocumentType r102 = DocumentType.DOC;
            if (TextUtils.equals(r100, r102.type) == true) goto L85;
            if (TextUtils.equals(r100, r102.getPathType()) == true) goto L85;
            DocumentType r103 = DocumentType.SHEET;
            if (TextUtils.equals(r100, r103.type) == true) goto L99;
            if (TextUtils.equals(r100, r103.getPathType()) == true) goto L99;
            DocumentType r104 = DocumentType.MINDNOTE;
            if (TextUtils.equals(r100, r104.type) == true) goto L98;
            if (TextUtils.equals(r100, r104.getPathType()) == true) goto L98;
            DocumentType r105 = DocumentType.BITABLE;
            if (TextUtils.equals(r100, r105.type) == true) goto L97;
            if (TextUtils.equals(r100, r105.getPathType()) == true) goto L97;
            DocumentType r106 = DocumentType.BASE_ADD;
            if (TextUtils.equals(r100, r106.type) == true) goto L96;
            if (TextUtils.equals(r100, r106.getPathType()) == true) goto L96;
            DocumentType r107 = DocumentType.FILE;
            if (TextUtils.equals(r100, r107.type) == true) goto L95;
            if (TextUtils.equals(r100, r107.getPathType()) == true) goto L95;
            DocumentType r108 = DocumentType.SLIDES;
            if (TextUtils.equals(r100, r108.type) == true) goto L94;
            if (TextUtils.equals(r100, r108.getPathType()) == true) goto L94;
            DocumentType r109 = DocumentType.FOLDER;
            if (TextUtils.equals(r100, r109.type) == true) goto L93;
            if (TextUtils.equals(r100, r109.getPathType()) == true) goto L93;
            DocumentType r110 = DocumentType.WIKI;
            if (TextUtils.equals(r100, r110.type) == true) goto L92;
            if (TextUtils.equals(r100, r110.getPathType()) == true) goto L92;
            DocumentType r111 = DocumentType.DOCX;
            if (TextUtils.equals(r100, r111.type) == true) goto L91;
            if (TextUtils.equals(r100, r111.getPathType()) == true) goto L91;
            DocumentType r112 = DocumentType.MINUTES;
            if (TextUtils.equals(r100, r112.type) == true) goto L90;
            if (TextUtils.equals(r100, r112.getPathType()) == true) goto L90;
            DocumentType r113 = DocumentType.OPEN_PLATFORM;
            if (TextUtils.equals(r100, r113.type) == true) goto L89;
            if (TextUtils.equals(r100, r113.getPathType()) == true) goto L89;
            DocumentType r114 = DocumentType.IM_FILE;
            if (TextUtils.equals(r100, r114.type) == true) goto L88;
            if (TextUtils.equals(r100, r114.getPathType()) == true) goto L88;
            DocumentType r115 = DocumentType.DOCX_SYNC_BLOCK;
            if (TextUtils.equals(r100, r115.type) == true) goto L87;
            if (TextUtils.equals(r100, r115.getPathType()) == true) goto L87;
            return r101;
        L87:
            return r115.getPathType();
        L88:
            return r114.getPathType();
        L89:
            return r113.getPathType();
        L90:
            return r112.getPathType();
        L91:
            return r111.getPathType();
        L92:
            return r110.getPathType();
        L93:
            return r109.getPathType();
        L94:
            return r108.getPathType();
        L95:
            return r107.getPathType();
        L96:
            return r106.getPathType();
        L97:
            return r105.getPathType();
        L98:
            return r104.getPathType();
        L99:
            return r103.getPathType();
        L85:
            return r102.getPathType();
        }

        public final String getDocumentReportTypeString(int r100) {
            if (r100 != DocumentType.FILE.getValue()) goto L7;
            return "drive";
        L7:
            return getDocumentTypeString(r100);
        }

        public final DocumentType getDocumentType(String r100) {
            DocumentType r101 = DocumentType.UNKNOWN;
            DocumentType r102 = DocumentType.DOC;
            if (TextUtils.equals(r100, r102.type) == true) goto L47;
            r102 = DocumentType.SHEET;
            if (TextUtils.equals(r100, r102.type) == true) goto L47;
            r102 = DocumentType.MINDNOTE;
            if (TextUtils.equals(r100, r102.type) == true) goto L47;
            r102 = DocumentType.BITABLE;
            if (TextUtils.equals(r100, r102.type) == true) goto L47;
            r102 = DocumentType.BASE_ADD;
            if (TextUtils.equals(r100, r102.type) == true) goto L47;
            r102 = DocumentType.FILE;
            if (TextUtils.equals(r100, r102.type) == true) goto L47;
            r102 = DocumentType.SLIDES;
            if (TextUtils.equals(r100, r102.type) == true) goto L47;
            r102 = DocumentType.FOLDER;
            if (TextUtils.equals(r100, r102.type) == true) goto L47;
            r102 = DocumentType.WIKI;
            if (TextUtils.equals(r100, r102.type) == true) goto L47;
            r102 = DocumentType.DOCX;
            if (TextUtils.equals(r100, r102.type) == true) goto L47;
            r102 = DocumentType.MINUTES;
            if (TextUtils.equals(r100, r102.type) == true) goto L47;
            r102 = DocumentType.BITABLE_FORM;
            if (TextUtils.equals(r100, r102.type) == true) goto L47;
            r102 = DocumentType.OPEN_PLATFORM;
            if (TextUtils.equals(r100, r102.type) == true) goto L47;
            r102 = DocumentType.IM_FILE;
            if (TextUtils.equals(r100, r102.type) == true) goto L47;
            r102 = DocumentType.DOCX_SYNC_BLOCK;
            if (TextUtils.equals(r100, r102.type) == true) goto L47;
            return r101;
        L47:
            return r102;
        }

        public final String getDocumentTypeString(int r100) {
            DocumentType r101 = DocumentType.DOC;
            if (r100 == r101.getValue()) goto L49;
            DocumentType r102 = DocumentType.FOLDER;
            if (r100 == r102.getValue()) goto L50;
            DocumentType r103 = DocumentType.SHEET;
            if (r100 == r103.getValue()) goto L51;
            DocumentType r104 = DocumentType.BITABLE;
            if (r100 == r104.getValue()) goto L52;
            DocumentType r105 = DocumentType.MINDNOTE;
            if (r100 == r105.getValue()) goto L53;
            DocumentType r106 = DocumentType.FILE;
            if (r100 == r106.getValue()) goto L54;
            DocumentType r107 = DocumentType.SLIDES;
            if (r100 == r107.getValue()) goto L55;
            DocumentType r108 = DocumentType.WIKI;
            if (r100 == r108.getValue()) goto L56;
            DocumentType r109 = DocumentType.DOCX;
            if (r100 == r109.getValue()) goto L57;
            DocumentType r110 = DocumentType.MINUTES;
            if (r100 == r110.getValue()) goto L58;
            DocumentType r111 = DocumentType.BITABLE_FORM;
            if (r100 == r111.getValue()) goto L59;
            DocumentType r112 = DocumentType.OPEN_PLATFORM;
            if (r100 == r112.getValue()) goto L60;
            DocumentType r113 = DocumentType.IM_FILE;
            if (r100 != r113.getValue()) goto L42;
            return r113.type;
        L42:
            if (r100 == 44) goto L62;
            DocumentType r114 = DocumentType.WIKI_FOLDER;
            if (r100 != r114.getValue()) goto L48;
            return r114.type;
        L48:
            return DocumentType.UNKNOWN.type;
        L62:
            return DocumentType.DOCX_SYNC_BLOCK.type;
        L60:
            return r112.type;
        L59:
            return r111.type;
        L58:
            return r110.type;
        L57:
            return r109.type;
        L56:
            return r108.type;
        L55:
            return r107.type;
        L54:
            return r106.type;
        L53:
            return r105.type;
        L52:
            return r104.type;
        L51:
            return r103.type;
        L50:
            return r102.type;
        L49:
            return r101.type;
        }

        @JvmStatic
        public final int getDocumentTypeValue(String r100) {
            int r101 = DocumentType.UNKNOWN.getValue();
            DocumentType r102 = DocumentType.DOC;
            if (TextUtils.equals(r100, r102.type) == true) goto L48;
            DocumentType r103 = DocumentType.SHEET;
            if (TextUtils.equals(r100, r103.type) == true) goto L49;
            DocumentType r104 = DocumentType.MINDNOTE;
            if (TextUtils.equals(r100, r104.type) == true) goto L50;
            DocumentType r105 = DocumentType.BITABLE;
            if (TextUtils.equals(r100, r105.type) == true) goto L51;
            DocumentType r106 = DocumentType.BASE_ADD;
            if (TextUtils.equals(r100, r106.type) == true) goto L52;
            DocumentType r107 = DocumentType.FILE;
            if (TextUtils.equals(r100, r107.type) == true) goto L53;
            DocumentType r108 = DocumentType.SLIDES;
            if (TextUtils.equals(r100, r108.type) == true) goto L54;
            DocumentType r109 = DocumentType.FOLDER;
            if (TextUtils.equals(r100, r109.type) == true) goto L55;
            DocumentType r110 = DocumentType.WIKI;
            if (TextUtils.equals(r100, r110.type) == true) goto L56;
            DocumentType r111 = DocumentType.DOCX;
            if (TextUtils.equals(r100, r111.type) == true) goto L57;
            DocumentType r112 = DocumentType.MINUTES;
            if (TextUtils.equals(r100, r112.type) == true) goto L58;
            DocumentType r113 = DocumentType.BITABLE_FORM;
            if (TextUtils.equals(r100, r113.type) == true) goto L59;
            DocumentType r114 = DocumentType.OPEN_PLATFORM;
            if (TextUtils.equals(r100, r114.type) == true) goto L60;
            DocumentType r115 = DocumentType.IM_FILE;
            if (TextUtils.equals(r100, r115.type) == true) goto L61;
            DocumentType r116 = DocumentType.DOCX_SYNC_BLOCK;
            if (TextUtils.equals(r100, r116.type) == true) goto L47;
            return r101;
        L47:
            return r116.getValue();
        L61:
            return r115.getValue();
        L60:
            return r114.getValue();
        L59:
            return r113.getValue();
        L58:
            return r112.getValue();
        L57:
            return r111.getValue();
        L56:
            return r110.getValue();
        L55:
            return r109.getValue();
        L54:
            return r108.getValue();
        L53:
            return r107.getValue();
        L52:
            return r106.getValue();
        L51:
            return r105.getValue();
        L50:
            return r104.getValue();
        L49:
            return r103.getValue();
        L48:
            return r102.getValue();
        }

        public final void setDOC_WEBVIEW_SUPPORT_TYPE_NAMES(List<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            DocumentType.access$setDOC_WEBVIEW_SUPPORT_TYPE_NAMES$cp(r100);
        }

        public final void setSUPPORT_FILE_TYPE_VALUES(Integer[] r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            DocumentType.access$setSUPPORT_FILE_TYPE_VALUES$cp(r100);
        }

        public final DocumentType getDocumentType(int r100) {
            DocumentType r101 = DocumentType.DOC;
            if (r100 == r101.getValue()) goto L49;
            DocumentType r102 = DocumentType.FOLDER;
            if (r100 == r102.getValue()) goto L50;
            DocumentType r103 = DocumentType.SHEET;
            if (r100 == r103.getValue()) goto L51;
            DocumentType r104 = DocumentType.BITABLE;
            if (r100 == r104.getValue()) goto L52;
            DocumentType r105 = DocumentType.BASE_ADD;
            if (r100 == r105.getValue()) goto L53;
            DocumentType r106 = DocumentType.MINDNOTE;
            if (r100 == r106.getValue()) goto L54;
            DocumentType r107 = DocumentType.FILE;
            if (r100 == r107.getValue()) goto L55;
            DocumentType r108 = DocumentType.SLIDES;
            if (r100 == r108.getValue()) goto L56;
            DocumentType r109 = DocumentType.WIKI;
            if (r100 == r109.getValue()) goto L57;
            DocumentType r110 = DocumentType.DOCX;
            if (r100 == r110.getValue()) goto L58;
            DocumentType r111 = DocumentType.MINUTES;
            if (r100 == r111.getValue()) goto L59;
            DocumentType r112 = DocumentType.BITABLE_FORM;
            if (r100 == r112.getValue()) goto L60;
            DocumentType r113 = DocumentType.OPEN_PLATFORM;
            if (r100 == r113.getValue()) goto L61;
            DocumentType r114 = DocumentType.IM_FILE;
            if (r100 == r114.getValue()) goto L62;
            DocumentType r115 = DocumentType.DOCX_SYNC_BLOCK;
            if (r100 != r115.getValue()) goto L48;
            return r115;
        L48:
            return DocumentType.UNKNOWN;
        L62:
            return r114;
        L61:
            return r113;
        L60:
            return r112;
        L59:
            return r111;
        L58:
            return r110;
        L57:
            return r109;
        L56:
            return r108;
        L55:
            return r107;
        L54:
            return r106;
        L53:
            return r105;
        L52:
            return r104;
        L51:
            return r103;
        L50:
            return r102;
        L49:
            return r101;
        }
    }

    @JvmStatic
    public static final int getDocumentTypeValue(String r100) {
        return Companion.getDocumentTypeValue(r100);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.type, Integer.valueOf(this.value)});
    }

    static {
        Companion = new Companion(null);
        DOC_WEBVIEW_SUPPORT_TYPE_NAMES = new ArrayList();
        UNKNOWN = new DocumentType(-1, "unknown", "unknown");
        DocumentType r100 = new DocumentType(0, FOLDER_NAME, FOLDER_NAME);
        FOLDER = r100;
        DocumentType r101 = new DocumentType(2, "doc", "doc");
        DOC = r101;
        DocumentType r102 = new DocumentType(3, SHEET_NAME, SHEET_NAME);
        SHEET = r102;
        DocumentType r103 = new DocumentType(8, BITABLE_NAME, BITABLE_NAME);
        BITABLE = r103;
        DocumentType r104 = new DocumentType(84, BASE_ADD_NAME, BASE_ADD_PATH_NAME);
        BASE_ADD = r104;
        DocumentType r105 = new DocumentType(11, MINDNOTE_NAME, MINDNOTE_NAME);
        MINDNOTE = r105;
        DocumentType r110 = new DocumentType(12, "file", "file");
        FILE = r110;
        DocumentType r111 = new DocumentType(30, "slides", "slides");
        SLIDES = r111;
        DocumentType r112 = new DocumentType(16, "wiki", "wiki");
        WIKI = r112;
        DocumentType r113 = new DocumentType(22, DOCX_NAME, DOCX_NAME);
        DOCX = r113;
        DOCX_WHITE_BOARD = new DocumentType(38, WIKI_FOLDER_NAME, WIKI_FOLDER_NAME);
        MINUTES = new DocumentType(28, MINUTES_NAME, MINUTES_NAME);
        BITABLE_FORM = new DocumentType(80, "form", "form");
        WIKI_FOLDER = new DocumentType(111, WIKI_FOLDER_NAME, WIKI_FOLDER_NAME);
        OPEN_PLATFORM = new DocumentType(200, "open_platform", "open_platform");
        IM_FILE = new DocumentType(998, IM_FILE_NAME, IM_FILE_NAME);
        DocumentType r106 = new DocumentType(44, DOCX_SYNC_BLOCK_NAME, DOCX_SYNC_BLOCK_NAME);
        DOCX_SYNC_BLOCK = r106;
        DOC_WEBVIEW_SUPPORT_TYPE_NAMES.add(r101.type);
        DOC_WEBVIEW_SUPPORT_TYPE_NAMES.add(r102.type);
        DOC_WEBVIEW_SUPPORT_TYPE_NAMES.add(r105.type);
        DOC_WEBVIEW_SUPPORT_TYPE_NAMES.add(r113.type);
        DOC_WEBVIEW_SUPPORT_TYPE_NAMES.add(r103.type);
        DOC_WEBVIEW_SUPPORT_TYPE_NAMES.add(r104.type);
        DOC_WEBVIEW_SUPPORT_TYPE_NAMES.add(r111.type);
        DOC_WEBVIEW_SUPPORT_TYPE_NAMES.add(r106.type);
        SUPPORT_FILE_TYPE_VALUES = new Integer[]{Integer.valueOf(r101.value), Integer.valueOf(r102.value), Integer.valueOf(r103.value), Integer.valueOf(r105.value), Integer.valueOf(r110.value), Integer.valueOf(r111.value), Integer.valueOf(r112.value), Integer.valueOf(r100.value), Integer.valueOf(r113.value), Integer.valueOf(r106.value)};
    }

    public static final /* synthetic */ List access$getDOC_WEBVIEW_SUPPORT_TYPE_NAMES$cp() {
        return DOC_WEBVIEW_SUPPORT_TYPE_NAMES;
    }

    public static final /* synthetic */ Integer[] access$getSUPPORT_FILE_TYPE_VALUES$cp() {
        return SUPPORT_FILE_TYPE_VALUES;
    }

    public final String getPathType() {
        return this.pathType;
    }

    public final int getValue() {
        return this.value;
    }

    public static final /* synthetic */ void access$setDOC_WEBVIEW_SUPPORT_TYPE_NAMES$cp(List r100) {
        DOC_WEBVIEW_SUPPORT_TYPE_NAMES = r100;
    }

    public static final /* synthetic */ void access$setSUPPORT_FILE_TYPE_VALUES$cp(Integer[] r100) {
        SUPPORT_FILE_TYPE_VALUES = r100;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (Intrinsics.areEqual(DocumentType.class, r100.getClass()) == false) goto L17;
        DocumentType r101 = (DocumentType) r100;
        if (this.value == r101.value) goto L13;
    L15:
        return false;
    L13:
        if (Intrinsics.areEqual(this.type, r101.type) == false) goto L15;
        return true;
    }

    public final void setPathType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pathType = r100;
    }

    public DocumentType(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "pathType");
        this.value = r100;
        this.type = r101;
        this.pathType = r102;
    }
}
