package uzb;

import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes37.dex */
public final class g {
    public static String a(String r100, FragmentActivity r101) {
        Matcher r102 = PatternProtector.compile("<span.*?style=['\"]?(.*?)['\"].*?").matcher(r100);
        String r103 = "";
        if (r102.find() == false) goto L5;
        String r104 = r102.group(1);
    L7:
        if (TextUtils.isEmpty(r104) == false) goto L10;
        return r100;
    L10:
        if (r104.contains(com.alipay.sdk.m.u.i.f25853b) == false) goto L12;
        String r105 = "(?<=color:)(.*?)(?=;)";
    L13:
        Matcher r106 = PatternProtector.compile(r105).matcher(r104);
        if (r106.find() == false) goto L16;
        String r107 = r106.group(1);
    L18:
        if (TextUtils.isEmpty(r107) == false) goto L20;
        return r100;
    L20:
        Matcher r108 = PatternProtector.compile("(?<=[{])(.+?)(?=[}])").matcher(r107);
        if (r108.find() == false) goto L24;
        r103 = r108.group(1);
    L24:
        if (TextUtils.isEmpty(r103) == false) goto L26;
        return r100;
    L26:
        int r109 = UDColorUtils.getColorIdByToken(r101, r103);
        StringBuilder r110 = new StringBuilder("#");
        int r111 = r101.getResources().getColor(r109);     // Catch: Resources.NotFoundException -> L29
    L31:
        r110.append(String.format("%02x", new Object[]{Integer.valueOf(Color.red(r111))}));
        r110.append(String.format("%02x", new Object[]{Integer.valueOf(Color.green(r111))}));
        r110.append(String.format("%02x", new Object[]{Integer.valueOf(Color.blue(r111))}));
        return r100.replace(r107, r110.toString());
    L29:
        e = move-exception;
        PassportLog.c("MatchUtil", "token: " + r103 + " not fount", e);
        r111 = 0;
        goto L31
    L16:
        r107 = "";
        goto L18
    L12:
        r105 = "(?<=color:)(.*)";
        goto L13
    L5:
        r104 = "";
        goto L7
    }
}
