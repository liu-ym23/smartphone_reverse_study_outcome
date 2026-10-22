package com.larus.bmhome.chat.layout.holder.helper;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.im.bean.message.Message;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class v1 {
    public static final void a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        com.larus.bmhome.view.screenmenu.l0 r101 = com.larus.bmhome.chat.layout.holder.menu.item.l.a();
        if (r101 == null) goto L6;
        ((ArrayList) r100).add(r101);
        return;
    }

    public static final long c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");     // Catch: Exception -> L5
        return ((ChatFragment) FragmentManager.findFragment(r100)).getChatUniqueKey();
    L5:
        FLogger.f375446a.d("IPopMenuCreator", "getChatUniqueKey error");
        return -1;
    }

    public static final void b(List r100, com.larus.bmhome.chat.api.q0.a r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == null) goto L9;
        com.larus.bmhome.chat.component.collection.o r102 = r101.i2();
        if (r102 == null) goto L9;
        if (r102.i0() != true) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L13;
        final Integer[] r104 = {Integer.valueOf(R.string.larus_message_long_press_copy), Integer.valueOf(R.string.larus_message_long_press_tts), Integer.valueOf(R.string.larus_message_long_press_select_text), Integer.valueOf(R.string.larus_message_long_press_debug)};
        com.larus.utils.h.e(r100, new t1(r104));
        return;
    L13:
        return;
    L9:
        r103 = false;
        goto L10
    }

    public static final void d(List r100, Message r101, wc9.e r102, com.larus.bmhome.chat.api.q0.a r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "data");
        if (r103 == null) goto L9;
        com.larus.bmhome.chat.component.collection.o r104 = r103.i2();
        if (r104 == null) goto L9;
        if (r104.i0() != true) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == false) goto L13;
        b(r100, r103);
        return;
    L13:
        final Integer[] r106 = {Integer.valueOf(R.string.larus_create_new_chat), Integer.valueOf(R.string.larus_message_long_press_tts)};
        if (r102 == null) goto L21;
        Long r107 = r102.f559213p;
        if (r107 != null) goto L18;
        return;
    L18:
        if (r101.getServerIndex() >= r107.longValue()) goto L23;
        com.larus.utils.h.e(r100, new u1(r106));
        return;
    L23:
        return;
    L21:
        return;
    L9:
        r105 = false;
        goto L10
    }
}
