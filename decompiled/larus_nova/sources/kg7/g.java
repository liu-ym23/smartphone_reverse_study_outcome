package kg7;

import com.bytedance.sync.v2.protocal.TopicType;

/* JADX INFO: loaded from: classes22.dex */
public final class g {
    public static int a(TopicType r100) {
        if (r100 != null) goto L6;
        return TopicType.SpecTopic.getValue();
    L6:
        return r100.getValue();
    }

    public static TopicType b(int r100) {
        TopicType r101 = TopicType.fromValue(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return TopicType.SpecTopic;
    }
}
