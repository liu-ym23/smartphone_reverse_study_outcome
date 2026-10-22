package com.bytedance.ee.docsdk.impl.base;

import android.text.TextUtils;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/base/DocumentType;", "", "value", "", ResourceData.KEY_TYPE, "", "pathType", "(ILjava/lang/String;Ljava/lang/String;)V", "getPathType", "()Ljava/lang/String;", "setPathType", "(Ljava/lang/String;)V", "getValue", "()I", "equals", "", "o", "hashCode", "Companion", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010!\n\u0002\b\u001e\n\u0002\u0010\u0011\n\u0002\b\u0018\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010L\u001a\u00020\u00062\b\u0010M\u001a\u0004\u0018\u00010\u0006J\u000e\u0010N\u001a\u00020\u00062\u0006\u0010M\u001a\u00020\tJ\u000e\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\tJ\u0010\u0010O\u001a\u00020\u00042\b\u0010Q\u001a\u0004\u0018\u00010\u0006J\u000e\u0010R\u001a\u00020\u00062\u0006\u0010M\u001a\u00020\tJ\u0012\u0010S\u001a\u00020\t2\b\u0010M\u001a\u0004\u0018\u00010\u0006H\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\"\u0010;\u001a\b\u0012\u0004\u0012\u00020\t0<X\u0086\u000e¢\u0006\u0010\n\u0002\u0010A\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0010\u0010B\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/base/DocumentType$Companion;", "", "()V", "BASE_ADD", "Lcom/bytedance/ee/docsdk/impl/base/DocumentType;", "BASE_ADD_NAME", "", "BASE_ADD_PATH_NAME", "BASE_ADD_VALUE", "", "BITABLE", "BITABLE_FORM", "BITABLE_FORM_NAME", "BITABLE_FORM_VALUE", "BITABLE_NAME", "BITABLE_VALUE", "DOC", "DOCX", "DOCX_NAME", "DOCX_SYNC_BLOCK", "DOCX_SYNC_BLOCK_NAME", "DOCX_SYNC_BLOCK_VALUE", "DOCX_VALUE", "DOCX_WHITE_BOARD", "DOCX_WHITE_BOARD_NAME", "DOCX_WHITE_BOARD_VALUE", "DOC_NAME", "DOC_VALUE", "DOC_WEBVIEW_SUPPORT_TYPE_NAMES", "", "getDOC_WEBVIEW_SUPPORT_TYPE_NAMES", "()Ljava/util/List;", "setDOC_WEBVIEW_SUPPORT_TYPE_NAMES", "(Ljava/util/List;)V", "FILE", "FILE_NAME", "FILE_VALUE", "FOLDER", "FOLDER_NAME", "FOLDER_VALUE", "IM_FILE", "IM_FILE_NAME", "IM_FILE_VALUE", "MINDNOTE", "MINDNOTE_NAME", "MINDNOTE_VALUE", "MINUTES", "MINUTES_NAME", "MINUTES_VALUE", "OPEN_PLATFORM", "OPEN_PLATFORM_NAME", "OPEN_PLATFORM_VALUE", "SHEET", "SHEET_NAME", "SHEET_VALUE", "SHORTCUT_VALUE", "SLIDES", "SLIDES_NAME", "SLIDES_VALUE", "SUPPORT_FILE_TYPE_VALUES", "", "getSUPPORT_FILE_TYPE_VALUES", "()[Ljava/lang/Integer;", "setSUPPORT_FILE_TYPE_VALUES", "([Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "UNKNOWN", "UNKNOWN_NAME", "UNKNOWN_VALUE", "VALUE_DRIVE", "WIKI", "WIKI_FOLDER", "WIKI_FOLDER_NAME", "WIKI_FOLDER_VALUE", "WIKI_NAME", "WIKI_VALUE", "getDocumentPathType", ResourceData.KEY_TYPE, "getDocumentReportTypeString", "getDocumentType", "typeValue", "typeName", "getDocumentTypeString", "getDocumentTypeValue", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final List<String> getDOC_WEBVIEW_SUPPORT_TYPE_NAMES() {
            return DocumentType.access$getDOC_WEBVIEW_SUPPORT_TYPE_NAMES$cp();
        }

        public final Integer[] getSUPPORT_FILE_TYPE_VALUES() {
            return DocumentType.access$getSUPPORT_FILE_TYPE_VALUES$cp();
        }

        public final String getDocumentPathType(String r4) {
            String r0 = DocumentType.UNKNOWN.getPathType();
            DocumentType r1 = DocumentType.DOC;
            if (TextUtils.equals(r4, r1.type) == true) goto L85;
            if (TextUtils.equals(r4, r1.getPathType()) == true) goto L85;
            DocumentType r2 = DocumentType.SHEET;
            if (TextUtils.equals(r4, r2.type) == true) goto L99;
            if (TextUtils.equals(r4, r2.getPathType()) == true) goto L99;
            DocumentType r3 = DocumentType.MINDNOTE;
            if (TextUtils.equals(r4, r3.type) == true) goto L98;
            if (TextUtils.equals(r4, r3.getPathType()) == true) goto L98;
            DocumentType r5 = DocumentType.BITABLE;
            if (TextUtils.equals(r4, r5.type) == true) goto L97;
            if (TextUtils.equals(r4, r5.getPathType()) == true) goto L97;
            DocumentType r6 = DocumentType.BASE_ADD;
            if (TextUtils.equals(r4, r6.type) == true) goto L96;
            if (TextUtils.equals(r4, r6.getPathType()) == true) goto L96;
            DocumentType r7 = DocumentType.FILE;
            if (TextUtils.equals(r4, r7.type) == true) goto L95;
            if (TextUtils.equals(r4, r7.getPathType()) == true) goto L95;
            DocumentType r8 = DocumentType.SLIDES;
            if (TextUtils.equals(r4, r8.type) == true) goto L94;
            if (TextUtils.equals(r4, r8.getPathType()) == true) goto L94;
            DocumentType r9 = DocumentType.FOLDER;
            if (TextUtils.equals(r4, r9.type) == true) goto L93;
            if (TextUtils.equals(r4, r9.getPathType()) == true) goto L93;
            DocumentType r10 = DocumentType.WIKI;
            if (TextUtils.equals(r4, r10.type) == true) goto L92;
            if (TextUtils.equals(r4, r10.getPathType()) == true) goto L92;
            DocumentType r11 = DocumentType.DOCX;
            if (TextUtils.equals(r4, r11.type) == true) goto L91;
            if (TextUtils.equals(r4, r11.getPathType()) == true) goto L91;
            DocumentType r12 = DocumentType.MINUTES;
            if (TextUtils.equals(r4, r12.type) == true) goto L90;
            if (TextUtils.equals(r4, r12.getPathType()) == true) goto L90;
            DocumentType r13 = DocumentType.OPEN_PLATFORM;
            if (TextUtils.equals(r4, r13.type) == true) goto L89;
            if (TextUtils.equals(r4, r13.getPathType()) == true) goto L89;
            DocumentType r14 = DocumentType.IM_FILE;
            if (TextUtils.equals(r4, r14.type) == true) goto L88;
            if (TextUtils.equals(r4, r14.getPathType()) == true) goto L88;
            DocumentType r15 = DocumentType.DOCX_SYNC_BLOCK;
            if (TextUtils.equals(r4, r15.type) == true) goto L87;
            if (TextUtils.equals(r4, r15.getPathType()) == true) goto L87;
            return r0;
        L87:
            return r15.getPathType();
        L88:
            return r14.getPathType();
        L89:
            return r13.getPathType();
        L90:
            return r12.getPathType();
        L91:
            return r11.getPathType();
        L92:
            return r10.getPathType();
        L93:
            return r9.getPathType();
        L94:
            return r8.getPathType();
        L95:
            return r7.getPathType();
        L96:
            return r6.getPathType();
        L97:
            return r5.getPathType();
        L98:
            return r3.getPathType();
        L99:
            return r2.getPathType();
        L85:
            return r1.getPathType();
        }

        public final String getDocumentReportTypeString(int r2) {
            if (r2 != DocumentType.FILE.getValue()) goto L7;
            return DocumentType.VALUE_DRIVE;
        L7:
            return getDocumentTypeString(r2);
        }

        public final DocumentType getDocumentType(String r4) {
            DocumentType r0 = DocumentType.UNKNOWN;
            DocumentType r1 = DocumentType.DOC;
            if (TextUtils.equals(r4, r1.type) == true) goto L47;
            r1 = DocumentType.SHEET;
            if (TextUtils.equals(r4, r1.type) == true) goto L47;
            r1 = DocumentType.MINDNOTE;
            if (TextUtils.equals(r4, r1.type) == true) goto L47;
            r1 = DocumentType.BITABLE;
            if (TextUtils.equals(r4, r1.type) == true) goto L47;
            r1 = DocumentType.BASE_ADD;
            if (TextUtils.equals(r4, r1.type) == true) goto L47;
            r1 = DocumentType.FILE;
            if (TextUtils.equals(r4, r1.type) == true) goto L47;
            r1 = DocumentType.SLIDES;
            if (TextUtils.equals(r4, r1.type) == true) goto L47;
            r1 = DocumentType.FOLDER;
            if (TextUtils.equals(r4, r1.type) == true) goto L47;
            r1 = DocumentType.WIKI;
            if (TextUtils.equals(r4, r1.type) == true) goto L47;
            r1 = DocumentType.DOCX;
            if (TextUtils.equals(r4, r1.type) == true) goto L47;
            r1 = DocumentType.MINUTES;
            if (TextUtils.equals(r4, r1.type) == true) goto L47;
            r1 = DocumentType.BITABLE_FORM;
            if (TextUtils.equals(r4, r1.type) == true) goto L47;
            r1 = DocumentType.OPEN_PLATFORM;
            if (TextUtils.equals(r4, r1.type) == true) goto L47;
            r1 = DocumentType.IM_FILE;
            if (TextUtils.equals(r4, r1.type) == true) goto L47;
            r1 = DocumentType.DOCX_SYNC_BLOCK;
            if (TextUtils.equals(r4, r1.type) == true) goto L47;
            return r0;
        L47:
            return r1;
        }

        public final String getDocumentTypeString(int r3) {
            DocumentType r0 = DocumentType.DOC;
            if (r3 == r0.getValue()) goto L49;
            DocumentType r1 = DocumentType.FOLDER;
            if (r3 == r1.getValue()) goto L50;
            DocumentType r2 = DocumentType.SHEET;
            if (r3 == r2.getValue()) goto L51;
            DocumentType r4 = DocumentType.BITABLE;
            if (r3 == r4.getValue()) goto L52;
            DocumentType r5 = DocumentType.MINDNOTE;
            if (r3 == r5.getValue()) goto L53;
            DocumentType r6 = DocumentType.FILE;
            if (r3 == r6.getValue()) goto L54;
            DocumentType r7 = DocumentType.SLIDES;
            if (r3 == r7.getValue()) goto L55;
            DocumentType r8 = DocumentType.WIKI;
            if (r3 == r8.getValue()) goto L56;
            DocumentType r9 = DocumentType.DOCX;
            if (r3 == r9.getValue()) goto L57;
            DocumentType r10 = DocumentType.MINUTES;
            if (r3 == r10.getValue()) goto L58;
            DocumentType r11 = DocumentType.BITABLE_FORM;
            if (r3 == r11.getValue()) goto L59;
            DocumentType r12 = DocumentType.OPEN_PLATFORM;
            if (r3 == r12.getValue()) goto L60;
            DocumentType r13 = DocumentType.IM_FILE;
            if (r3 != r13.getValue()) goto L42;
            return r13.type;
        L42:
            if (r3 == 44) goto L62;
            DocumentType r14 = DocumentType.WIKI_FOLDER;
            if (r3 != r14.getValue()) goto L48;
            return r14.type;
        L48:
            return DocumentType.UNKNOWN.type;
        L62:
            return DocumentType.DOCX_SYNC_BLOCK.type;
        L60:
            return r12.type;
        L59:
            return r11.type;
        L58:
            return r10.type;
        L57:
            return r9.type;
        L56:
            return r8.type;
        L55:
            return r7.type;
        L54:
            return r6.type;
        L53:
            return r5.type;
        L52:
            return r4.type;
        L51:
            return r2.type;
        L50:
            return r1.type;
        L49:
            return r0.type;
        }

        @JvmStatic
        public final int getDocumentTypeValue(String r4) {
            int r0 = DocumentType.UNKNOWN.getValue();
            DocumentType r1 = DocumentType.DOC;
            if (TextUtils.equals(r4, r1.type) == true) goto L48;
            DocumentType r2 = DocumentType.SHEET;
            if (TextUtils.equals(r4, r2.type) == true) goto L49;
            DocumentType r3 = DocumentType.MINDNOTE;
            if (TextUtils.equals(r4, r3.type) == true) goto L50;
            DocumentType r5 = DocumentType.BITABLE;
            if (TextUtils.equals(r4, r5.type) == true) goto L51;
            DocumentType r6 = DocumentType.BASE_ADD;
            if (TextUtils.equals(r4, r6.type) == true) goto L52;
            DocumentType r7 = DocumentType.FILE;
            if (TextUtils.equals(r4, r7.type) == true) goto L53;
            DocumentType r8 = DocumentType.SLIDES;
            if (TextUtils.equals(r4, r8.type) == true) goto L54;
            DocumentType r9 = DocumentType.FOLDER;
            if (TextUtils.equals(r4, r9.type) == true) goto L55;
            DocumentType r10 = DocumentType.WIKI;
            if (TextUtils.equals(r4, r10.type) == true) goto L56;
            DocumentType r11 = DocumentType.DOCX;
            if (TextUtils.equals(r4, r11.type) == true) goto L57;
            DocumentType r12 = DocumentType.MINUTES;
            if (TextUtils.equals(r4, r12.type) == true) goto L58;
            DocumentType r13 = DocumentType.BITABLE_FORM;
            if (TextUtils.equals(r4, r13.type) == true) goto L59;
            DocumentType r14 = DocumentType.OPEN_PLATFORM;
            if (TextUtils.equals(r4, r14.type) == true) goto L60;
            DocumentType r15 = DocumentType.IM_FILE;
            if (TextUtils.equals(r4, r15.type) == true) goto L61;
            DocumentType r16 = DocumentType.DOCX_SYNC_BLOCK;
            if (TextUtils.equals(r4, r16.type) == true) goto L47;
            return r0;
        L47:
            return r16.getValue();
        L61:
            return r15.getValue();
        L60:
            return r14.getValue();
        L59:
            return r13.getValue();
        L58:
            return r12.getValue();
        L57:
            return r11.getValue();
        L56:
            return r10.getValue();
        L55:
            return r9.getValue();
        L54:
            return r8.getValue();
        L53:
            return r7.getValue();
        L52:
            return r6.getValue();
        L51:
            return r5.getValue();
        L50:
            return r3.getValue();
        L49:
            return r2.getValue();
        L48:
            return r1.getValue();
        }

        public final void setDOC_WEBVIEW_SUPPORT_TYPE_NAMES(List<String> r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            DocumentType.access$setDOC_WEBVIEW_SUPPORT_TYPE_NAMES$cp(r2);
        }

        public final void setSUPPORT_FILE_TYPE_VALUES(Integer[] r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            DocumentType.access$setSUPPORT_FILE_TYPE_VALUES$cp(r2);
        }

        public final DocumentType getDocumentType(int r3) {
            DocumentType r0 = DocumentType.DOC;
            if (r3 == r0.getValue()) goto L49;
            DocumentType r1 = DocumentType.FOLDER;
            if (r3 == r1.getValue()) goto L50;
            DocumentType r2 = DocumentType.SHEET;
            if (r3 == r2.getValue()) goto L51;
            DocumentType r4 = DocumentType.BITABLE;
            if (r3 == r4.getValue()) goto L52;
            DocumentType r5 = DocumentType.BASE_ADD;
            if (r3 == r5.getValue()) goto L53;
            DocumentType r6 = DocumentType.MINDNOTE;
            if (r3 == r6.getValue()) goto L54;
            DocumentType r7 = DocumentType.FILE;
            if (r3 == r7.getValue()) goto L55;
            DocumentType r8 = DocumentType.SLIDES;
            if (r3 == r8.getValue()) goto L56;
            DocumentType r9 = DocumentType.WIKI;
            if (r3 == r9.getValue()) goto L57;
            DocumentType r10 = DocumentType.DOCX;
            if (r3 == r10.getValue()) goto L58;
            DocumentType r11 = DocumentType.MINUTES;
            if (r3 == r11.getValue()) goto L59;
            DocumentType r12 = DocumentType.BITABLE_FORM;
            if (r3 == r12.getValue()) goto L60;
            DocumentType r13 = DocumentType.OPEN_PLATFORM;
            if (r3 == r13.getValue()) goto L61;
            DocumentType r14 = DocumentType.IM_FILE;
            if (r3 == r14.getValue()) goto L62;
            DocumentType r15 = DocumentType.DOCX_SYNC_BLOCK;
            if (r3 != r15.getValue()) goto L48;
            return r15;
        L48:
            return DocumentType.UNKNOWN;
        L62:
            return r14;
        L61:
            return r13;
        L60:
            return r12;
        L59:
            return r11;
        L58:
            return r10;
        L57:
            return r9;
        L56:
            return r8;
        L55:
            return r7;
        L54:
            return r6;
        L53:
            return r5;
        L52:
            return r4;
        L51:
            return r2;
        L50:
            return r1;
        L49:
            return r0;
        }
    }

    @JvmStatic
    public static final int getDocumentTypeValue(String r1) {
        return Companion.getDocumentTypeValue(r1);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.type, Integer.valueOf(this.value)});
    }

    static {
        Companion = new Companion(null);
        DOC_WEBVIEW_SUPPORT_TYPE_NAMES = new ArrayList();
        UNKNOWN = new DocumentType(-1, "unknown", "unknown");
        DocumentType r0 = new DocumentType(0, FOLDER_NAME, FOLDER_NAME);
        FOLDER = r0;
        DocumentType r1 = new DocumentType(2, DOC_NAME, DOC_NAME);
        DOC = r1;
        DocumentType r3 = new DocumentType(3, SHEET_NAME, SHEET_NAME);
        SHEET = r3;
        DocumentType r5 = new DocumentType(8, BITABLE_NAME, BITABLE_NAME);
        BITABLE = r5;
        DocumentType r7 = new DocumentType(84, BASE_ADD_NAME, BASE_ADD_PATH_NAME);
        BASE_ADD = r7;
        DocumentType r9 = new DocumentType(11, MINDNOTE_NAME, MINDNOTE_NAME);
        MINDNOTE = r9;
        DocumentType r10 = new DocumentType(12, FILE_NAME, FILE_NAME);
        FILE = r10;
        DocumentType r11 = new DocumentType(30, "slides", "slides");
        SLIDES = r11;
        DocumentType r12 = new DocumentType(16, WIKI_NAME, WIKI_NAME);
        WIKI = r12;
        DocumentType r13 = new DocumentType(22, DOCX_NAME, DOCX_NAME);
        DOCX = r13;
        DOCX_WHITE_BOARD = new DocumentType(38, WIKI_FOLDER_NAME, WIKI_FOLDER_NAME);
        MINUTES = new DocumentType(28, MINUTES_NAME, MINUTES_NAME);
        BITABLE_FORM = new DocumentType(80, BITABLE_FORM_NAME, BITABLE_FORM_NAME);
        WIKI_FOLDER = new DocumentType(111, WIKI_FOLDER_NAME, WIKI_FOLDER_NAME);
        OPEN_PLATFORM = new DocumentType(200, OPEN_PLATFORM_NAME, OPEN_PLATFORM_NAME);
        IM_FILE = new DocumentType(IM_FILE_VALUE, IM_FILE_NAME, IM_FILE_NAME);
        DocumentType r6 = new DocumentType(44, DOCX_SYNC_BLOCK_NAME, DOCX_SYNC_BLOCK_NAME);
        DOCX_SYNC_BLOCK = r6;
        DOC_WEBVIEW_SUPPORT_TYPE_NAMES.add(r1.type);
        DOC_WEBVIEW_SUPPORT_TYPE_NAMES.add(r3.type);
        DOC_WEBVIEW_SUPPORT_TYPE_NAMES.add(r9.type);
        DOC_WEBVIEW_SUPPORT_TYPE_NAMES.add(r13.type);
        DOC_WEBVIEW_SUPPORT_TYPE_NAMES.add(r5.type);
        DOC_WEBVIEW_SUPPORT_TYPE_NAMES.add(r7.type);
        DOC_WEBVIEW_SUPPORT_TYPE_NAMES.add(r11.type);
        DOC_WEBVIEW_SUPPORT_TYPE_NAMES.add(r6.type);
        SUPPORT_FILE_TYPE_VALUES = new Integer[]{Integer.valueOf(r1.value), Integer.valueOf(r3.value), Integer.valueOf(r5.value), Integer.valueOf(r9.value), Integer.valueOf(r10.value), Integer.valueOf(r11.value), Integer.valueOf(r12.value), Integer.valueOf(r0.value), Integer.valueOf(r13.value), Integer.valueOf(r6.value)};
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

    public static final /* synthetic */ void access$setDOC_WEBVIEW_SUPPORT_TYPE_NAMES$cp(List r0) {
        DOC_WEBVIEW_SUPPORT_TYPE_NAMES = r0;
    }

    public static final /* synthetic */ void access$setSUPPORT_FILE_TYPE_VALUES$cp(Integer[] r0) {
        SUPPORT_FILE_TYPE_VALUES = r0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (Intrinsics.areEqual(DocumentType.class, r5.getClass()) == false) goto L17;
        DocumentType r6 = (DocumentType) r5;
        if (this.value == r6.value) goto L13;
    L15:
        return false;
    L13:
        if (Intrinsics.areEqual(this.type, r6.type) == false) goto L15;
        return true;
    }

    public final void setPathType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.pathType = r2;
    }

    public DocumentType(int r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TYPE);
        Intrinsics.checkNotNullParameter(r4, "pathType");
        this.value = r2;
        this.type = r3;
        this.pathType = r4;
    }
}
