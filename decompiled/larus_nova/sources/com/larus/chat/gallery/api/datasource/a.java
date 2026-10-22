package com.larus.chat.gallery.api.datasource;

import com.larus.chat.gallery.api.bean.GalleryChatType;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.MessageQueryType;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f324142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Message f324143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f324144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f324145d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f324146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f324147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f324148g;

    /* JADX INFO: renamed from: com.larus.chat.gallery.api.datasource.a$a, reason: collision with other inner class name */
    public static final class C4169a {
    }

    static {
    }

    public final List<Long> b() {
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = this.f324142a.iterator();
    L4:
        if (r101.hasNext() == false) goto L23;
        String r102 = (String) r101.next();
        int r103 = r102.hashCode();
        if (r103 != (-958719347)) goto L8;
        if (r102.equals(GalleryChatType.HOMEWORK_CORRECTION) == false) goto L4;
        r100.add(Long.valueOf(MessageQueryType.MESSAGE_QUERY_TYPE_HOMEWORK_CORRECTION));
        goto L4
    L8:
        if (r103 != (-357806106)) goto L10;
        if (r102.equals(GalleryChatType.CHAT_CREATION) == false) goto L4;
        r100.add(Long.valueOf(MessageQueryType.MESSAGE_QUERY_TYPE_IMAGE_CREATION));
        r100.add(Long.valueOf(MessageQueryType.MESSAGE_QUERY_TYPE_VIDEO_CREATION));
        goto L4
    L10:
        if (r103 != 1620069391) goto L4;
        if (r102.equals(GalleryChatType.CHAT_SEND) == false) goto L4;
        r100.add(Long.valueOf(MessageQueryType.MESSAGE_QUERY_TYPE_IMAGE_UPLOAD));
        r100.add(Long.valueOf(MessageQueryType.MESSAGE_QUERY_TYPE_VIDEO_UPLOAD));
        goto L4
    L23:
        return r100;
    }

    public a(List<String> r100, Message r101) {
        Intrinsics.checkNotNullParameter(r100, "messageTypeList");
        this.f324142a = r100;
        this.f324143b = r101;
        if (r101 == null) goto L5;
        long r102 = r101.getCreateTime();
    L6:
        this.f324144c = r102 * ((long) 1000);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public static final void a(a r100, List r101) {
        r100.getClass();
        StringBuilder r102 = new StringBuilder("list print:size: ");
        if (r101 == null) goto L5;
        Integer r103 = Integer.valueOf(r101.size());
    L6:
        r102.append(r103);
        r102.append("; ");
        String r104 = r102.toString();
        if (r101 == null) goto L12;
        Iterator r105 = r101.iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        r104 = r104 + ((Message) r105.next()).getMessageId() + ", ";
    L12:
        FLogger.f375446a.i("GalleryMessageLoadProcessor", r104 + "; print end");
        return;
    L5:
        r103 = null;
        goto L6
    }
}
