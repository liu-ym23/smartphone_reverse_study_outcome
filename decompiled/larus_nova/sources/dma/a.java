package dma;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f469233a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f469234b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f469235c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f469236d = null;

    static {
        f469233a = new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, FaceService.girlLabel, "G", FaceService.neutralLabel, "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", "V", ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", ".>"};
        f469234b = new String[]{"ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ", "ㅂ", "ㅅ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ", ".~", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, FaceService.girlLabel, "G", FaceService.neutralLabel, "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", "V", ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", ".>"};
        f469235c = new String[]{"あ", "い", "う", "え", "お", "か", "き", "く", "け", "こ", "さ", "し", "す", "せ", "そ", "た", "ち", "つ", "て", "と", "な", "に", "ぬ", "ね", "の", "は", "ひ", "ふ", "へ", "ほ", "ま", "み", "む", "め", "も", "や", "*い", "ゆ", "*え", "よ", "ら", "り", "る", "れ", "ろ", "わ", "*い", "*う", "*え", "を", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, FaceService.girlLabel, "G", FaceService.neutralLabel, "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", "V", ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", ".~", ".~", ".~", ".>"};
        f469236d = new String[]{"А", "Б", "В", "Г", "Д", "Е", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ъ", "Ы", "Ь", "Э", "Ю", "Я", ".~", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, FaceService.girlLabel, "G", FaceService.neutralLabel, "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", "V", ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", ".>"};
    }

    public static boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "alphabet");
        String[] r101 = (String[]) Arrays.copyOfRange(f469236d, 0, 32);
        return Arrays.asList(Arrays.copyOf(r101, r101.length)).contains(r100);
    }

    public static int b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "language");
        if (Intrinsics.areEqual(Locale.CHINESE.getLanguage(), r100) == false) goto L6;
    L17:
        return 0;
    L6:
        if (Intrinsics.areEqual(Locale.ENGLISH.getLanguage(), r100) == false) goto L9;
    L16:
        return 1;
    L9:
        if (Intrinsics.areEqual(Locale.KOREA.getLanguage(), r100) == true) goto L17;
        if (Intrinsics.areEqual(Locale.JAPAN.getLanguage(), r100) == true) goto L16;
        if (Intrinsics.areEqual("ru", r100) == false) goto L17;
        goto L16
    }
}
