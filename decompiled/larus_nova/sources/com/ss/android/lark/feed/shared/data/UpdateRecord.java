package com.ss.android.lark.feed.shared.data;

import com.ss.android.lark.feed.app.entity.FeedFolder;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public final class UpdateRecord {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f421127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<UIFeedCard> f421128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f421129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f421130d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f421131e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<ICache$Operation> f421132f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FeedFolder f421133g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FeedFolder f421134h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<FeedFolder, UpdateRecord> f421135i;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FeedPacketType {
        public static final int DONE = 1;
        public static final int FILTER = 3;
        public static final int HEADER = 2;
        public static final int INBOX = 0;
    }

    public UpdateRecord() {
        this.f421130d = false;
    }

    public final void a(List<UIFeedCard> r100) {
        ArrayList r101 = new ArrayList();
        Iterator<UIFeedCard> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        UIFeedCard r103 = r102.next();
        if (r103 == null) goto L4;
        r101.add(r103);
        goto L4
    L8:
        this.f421128b = r101;
    }
}
