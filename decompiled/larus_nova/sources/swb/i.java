package swb;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes37.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f543774a = null;

    static {
        f543774a = PatternProtector.compile("((sht|doc|dox|bas|app|sld|bmn|fld|nod|box|jsn|img|isv|wik|wia|wib|wic|wid|wie|whb)(cn|us|lg|jp)[A-Za-z0-9]{22})|[A-Z][a-zA-Z0-9]{3}([sdbafnjiw])[a-zA-Z0-9]{4}([oaplmsih])[a-zA-Z0-9]{4}([txspdngvkabce])[a-zA-Z0-9]{4}([culj])[a-zA-Z0-9]{4}([nsgp])[a-zA-Z0-9]{2}");
    }

    public static String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return r100;
    L10:
        return f543774a.matcher(r100).replaceAll("token is sensitive **** ");
    L7:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d("EncriptUtils", e);
        return r100;
    }
}
