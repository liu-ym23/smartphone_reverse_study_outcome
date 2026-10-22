package opc;

import android.content.Context;
import android.text.format.Formatter;
import com.ss.android.lark.forwardv3.ExternalForwardSendMode;
import com.ss.android.lark.forwardv3.configuration.BasicDialogContentConfig;
import com.ss.android.lark.forwardv3.configuration.Forward$Source;
import com.ss.android.lark.forwardv3.configuration.ForwardAdditionNoteConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardCommonConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardConfirmDialogConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardSelectConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTargetConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$Tenant;
import com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem;
import com.ss.android.lark.forwardv3.configuration.targetconfig.GroupConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.IncludeConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.ThreadConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig;
import com.ss.android.lark.utils.a0;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.platform.feature.forward.doubao.file.DoubaoFileForwardContent;
import com.suite.lark.platform.feature.forward.doubao.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f524827a = 0;

    static {
    }

    public static boolean a(Context r210, npc.a r211) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "request");
        if (r211.a() == true) goto L5;
        return false;
    L5:
        ForwardTemplateNew.a r100 = new ForwardTemplateNew.a();
        r100.f425212g = 10;
        Forward$Source r101 = Forward$Source.DOUBAO;
        Intrinsics.checkNotNullParameter(r101, "source");
        r100.f425213h = r101;
        r100.f425211f = new DoubaoFileForwardContent(r211);
        ForwardCommonConfig.a r102 = new ForwardCommonConfig.a();
        r102.f425169b = false;
        ForwardCommonConfig r103 = r102.a();
        Intrinsics.checkNotNullParameter(r103, "forwardCommonConfig");
        r100.f425208c = r103;
        ForwardTargetConfig.a r104 = new ForwardTargetConfig.a();
        IncludeConfig.a r105 = new IncludeConfig.a();
        EntityItem.a r106 = new EntityItem.a();
        UserConfig.a r107 = new UserConfig.a();
        Condition$Tenant r108 = Condition$Tenant.NOT_CROSS_TENANT;
        r107.b(r108);
        r106.f(r107.a());
        r105.a(r106.c());
        EntityItem.a r109 = new EntityItem.a();
        GroupConfig.a r110 = new GroupConfig.a();
        r110.b(r108);
        r109.d(r110.a());
        r105.a(r109.c());
        EntityItem.a r111 = new EntityItem.a();
        ThreadConfig.a r112 = new ThreadConfig.a();
        Intrinsics.checkNotNullParameter(r108, "tenant");
        r112.f425252a = r108;
        r111.e(r112.a());
        r105.a(r111.c());
        IncludeConfig r113 = r105.b();
        Intrinsics.checkNotNullParameter(r113, "includeConfig");
        r104.f425204d = r113;
        r104.f425201a = true;
        ForwardTargetConfig r114 = r104.a();
        Intrinsics.checkNotNullParameter(r114, "forwardTargetConfig");
        r100.f425206a = r114;
        ForwardSelectConfig.a r115 = new ForwardSelectConfig.a();
        r115.f425192b = false;
        r115.f425191a = false;
        ForwardSelectConfig r116 = r115.a();
        Intrinsics.checkNotNullParameter(r116, "forwardSelectConfig");
        r100.f425207b = r116;
        ForwardAdditionNoteConfig.a r117 = new ForwardAdditionNoteConfig.a();
        r117.f425157a = true;
        r117.f425158b = false;
        ForwardAdditionNoteConfig r118 = r117.a();
        Intrinsics.checkNotNullParameter(r118, "forwardAdditionNoteConfig");
        r100.f425209d = r118;
        ForwardConfirmDialogConfig.a r119 = new ForwardConfirmDialogConfig.a();
        BasicDialogContentConfig.a r120 = new BasicDialogContentConfig.a();
        String r121 = r211.f520069b;
        Intrinsics.checkNotNullParameter(r121, "title");
        r120.f425140b = r121;
        String r122 = "";
        String r123 = StringsKt.substringAfterLast(r211.f520069b, '.', "").toUpperCase(Locale.ROOT);
        Long r124 = Long.valueOf(r211.f520071d);
        if (r124.longValue() <= 0) goto L8;
        boolean r125 = true;
    L10:
        if (r125 == true) goto L13;
        r124 = null;
    L13:
        if (r124 == null) goto L15;
        String r126 = Formatter.formatFileSize(r210, r124.longValue());
    L16:
        if (r126 == null) goto L19;
        r122 = r126;
    L19:
        List r127 = CollectionsKt.listOf(new String[]{r123, r122});
        ArrayList r128 = new ArrayList();
        Iterator r129 = r127.iterator();
    L21:
        if (r129.hasNext() == false) goto L25;
        Object r130 = r129.next();
        if ((!StringsKt.isBlank((String) r130)) == false) goto L21;
        r128.add(r130);
        goto L21
    L25:
        String r131 = CollectionsKt.joinToString$default(r128, tb2.c.DEFAULT_TEXT, null, null, 0, null, null, 62, null);
        Intrinsics.checkNotNullParameter(r131, "description");
        r120.f425142d = r131;
        r120.f425144f = a0.b(r211.f520072e, r211.f520069b, 1);
        r120.f425145g = null;
        r120.f425146h = null;
        r120.f425147i = null;
        r119.f425184d = r120.a();
        ForwardConfirmDialogConfig r132 = r119.a();
        Intrinsics.checkNotNullParameter(r132, "forwardConfirmDialogConfig");
        r100.f425210e = r132;
        ForwardTemplateNew r133 = r100.a();
        int r134 = u.f461370a;
        u.a(r210, r133, 0, ExternalForwardSendMode.MIXED_EXTERNAL_TARGET, 4);
        return true;
    L15:
        r126 = null;
        goto L16
    L8:
        r125 = false;
        goto L10
    }
}
