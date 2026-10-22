package vhb;

import com.bytedance.lark.pb.basic.v1.Gradient;
import com.bytedance.lark.pb.basic.v1.ThemeColor;
import com.ss.android.lark.utils.FileType;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f554991a = 0;

    /* JADX INFO: renamed from: vhb.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C8008a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f554992a = null;

        static {
            int[] r100 = new int[FileType.values().length];
            r100[FileType.TYPE_PDF.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L71:
            r100[FileType.TYPE_PPT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L83:
            r100[FileType.TYPE_DOC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L53:
            r100[FileType.TYPE_XLS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L57:
            r100[FileType.TYPE_ZIP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
        L65:
            r100[FileType.TYPE_PSD.ordinal()] = 6;     // Catch: NoSuchFieldError -> L30
        L77:
            r100[FileType.TYPE_IMG.ordinal()] = 7;     // Catch: NoSuchFieldError -> L31
        L61:
            r100[FileType.TYPE_VIDEO.ordinal()] = 8;     // Catch: NoSuchFieldError -> L32
        L73:
            r100[FileType.TYPE_AUDIO.ordinal()] = 9;     // Catch: NoSuchFieldError -> L33
        L75:
            r100[FileType.TYPE_TXT.ordinal()] = 10;     // Catch: NoSuchFieldError -> L34
        L47:
            r100[FileType.TYPE_APK.ordinal()] = 11;     // Catch: NoSuchFieldError -> L35
        L69:
            r100[FileType.TYPE_AI.ordinal()] = 12;     // Catch: NoSuchFieldError -> L36
        L81:
            r100[FileType.TYPE_SKETCH.ordinal()] = 13;     // Catch: NoSuchFieldError -> L37
        L45:
            r100[FileType.TYPE_AE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L38
        L59:
            r100[FileType.TYPE_KEYNOTE.ordinal()] = 15;     // Catch: NoSuchFieldError -> L39
        L79:
            r100[FileType.TYPE_NUMBERS.ordinal()] = 16;     // Catch: NoSuchFieldError -> L40
        L51:
            r100[FileType.TYPE_PAGES.ordinal()] = 17;     // Catch: NoSuchFieldError -> L41
        L55:
            r100[FileType.TYPE_EML.ordinal()] = 18;     // Catch: NoSuchFieldError -> L42
        L67:
            r100[FileType.TYPE_MSG.ordinal()] = 19;     // Catch: NoSuchFieldError -> L43
        L49:
            r100[FileType.TYPE_FOLDER.ordinal()] = 20;     // Catch: NoSuchFieldError -> L44
        L23:
            f554992a = r100;
        }
    }

    static {
    }

    public static Gradient a() {
        return new Gradient.Builder().type(Gradient.Type.LINEAR).linear(new Gradient.Linear.Builder().deg(0).colors_v2(CollectionsKt.listOf(new ThemeColor.Builder().token("imtoken_message_card_bg_body_embed").build())).build()).build();
    }
}
