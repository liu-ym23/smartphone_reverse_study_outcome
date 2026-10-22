package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.OthersPermission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Symlink;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes42.dex */
public final class ClassMapperLite {
    public static final ClassMapperLite INSTANCE = null;

    /* JADX INFO: renamed from: kotlin, reason: collision with root package name */
    private static final String f504581kotlin = null;
    private static final Map<String, String> map = null;

    private ClassMapperLite() {
    }

    static {
        INSTANCE = new ClassMapperLite();
        int r100 = 0;
        f504581kotlin = CollectionsKt.joinToString$default(CollectionsKt.listOf(new Character[]{'k', 'o', Character.valueOf(OthersPermission.STICKY_E), Character.valueOf(Symlink.UNIX_ID), 'i', 'n'}), "", null, null, 0, null, null, 62, null);
        LinkedHashMap r101 = new LinkedHashMap();
        List r102 = CollectionsKt.listOf(new String[]{"Boolean", "Z", "Char", "C", "Byte", "B", "Short", ExifInterface.LATITUDE_SOUTH, "Int", "I", "Float", FaceService.girlLabel, "Long", "J", "Double", "D"});
        int r103 = ProgressionUtilKt.getProgressionLastElement(0, r102.size() - 1, 2);
        if (r103 < 0) goto L8;
        int r104 = 0;
    L5:
        StringBuilder r105 = new StringBuilder();
        String r106 = f504581kotlin;
        r105.append(r106);
        r105.append('/');
        r105.append((String) ListProtector.get(r102, r104));
        int r107 = r104 + 1;
        r101.put(r105.toString(), ListProtector.get(r102, r107));
        r101.put(r106 + '/' + ((String) ListProtector.get(r102, r104)) + "Array", "[" + ((String) ListProtector.get(r102, r107)));
        if (r104 == r103) goto L8;
        r104 = r104 + 2;
    L8:
        r101.put(f504581kotlin + "/Unit", "V");
        map$lambda$0$add(r101, "Any", "java/lang/Object");
        map$lambda$0$add(r101, "Nothing", "java/lang/Void");
        map$lambda$0$add(r101, "Annotation", "java/lang/annotation/Annotation");
        Iterator r108 = CollectionsKt.listOf(new String[]{"String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum"}).iterator();
    L10:
        if (r108.hasNext() == false) goto L12;
        String r109 = (String) r108.next();
        map$lambda$0$add(r101, r109, "java/lang/" + r109);
        goto L10
    L12:
        Iterator r110 = CollectionsKt.listOf(new String[]{"Iterator", "Collection", "List", "Set", "Map", "ListIterator"}).iterator();
    L14:
        if (r110.hasNext() == false) goto L16;
        String r111 = (String) r110.next();
        map$lambda$0$add(r101, "collections/" + r111, "java/util/" + r111);
        map$lambda$0$add(r101, "collections/Mutable" + r111, "java/util/" + r111);
        goto L14
    L16:
        map$lambda$0$add(r101, "collections/Iterable", "java/lang/Iterable");
        map$lambda$0$add(r101, "collections/MutableIterable", "java/lang/Iterable");
        map$lambda$0$add(r101, "collections/Map.Entry", "java/util/Map$Entry");
        map$lambda$0$add(r101, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
    L18:
        if (r100 >= 23) goto L20;
        StringBuilder r112 = new StringBuilder();
        String r113 = f504581kotlin;
        r112.append(r113);
        r112.append("/jvm/functions/Function");
        r112.append(r100);
        map$lambda$0$add(r101, "Function" + r100, r112.toString());
        map$lambda$0$add(r101, "reflect/KFunction" + r100, r113 + "/reflect/KFunction");
        r100 = r100 + 1;
        goto L18
    L20:
        Iterator r114 = CollectionsKt.listOf(new String[]{"Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum"}).iterator();
    L22:
        if (r114.hasNext() == false) goto L24;
        String r115 = (String) r114.next();
        map$lambda$0$add(r101, r115 + ".Companion", f504581kotlin + "/jvm/internal/" + r115 + "CompanionObject");
        goto L22
    L24:
        map = r101;
    }

    @JvmStatic
    public static final String mapClass(String r100) {
        Intrinsics.checkNotNullParameter(r100, "classId");
        String r101 = map.get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return "L" + StringsKt.replace$default(r100, '.', Typography.dollar, false, 4, null) + ';';
    }

    private static final void map$lambda$0$add(Map<String, String> r100, String r101, String r102) {
        r100.put(f504581kotlin + '/' + r101, "L" + r102 + ';');
    }
}
