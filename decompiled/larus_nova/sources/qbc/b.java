package qbc;

import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.vote.v1.VotedIndexInfo;
import com.ss.android.lark.parser.internal.a0;
import com.ss.android.lark.vote.message.content.VoteUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f532428a = 0;

    static {
    }

    public static long a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "voteIndexesInfos");
        Iterator r101 = r100.iterator();
        long r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L10;
        VotedIndexInfo r103 = (VotedIndexInfo) r101.next();
        if (r103 == null) goto L8;
        long r104 = r103.count.longValue();
    L9:
        r102 = r102 + r104;
        goto L4
    L8:
        r104 = 0;
        goto L9
    L10:
        return r102;
    }

    public static List c(List r100) {
        Intrinsics.checkNotNullParameter(r100, "rawVotedInfo");
        VotedIndexInfo[] r101 = new VotedIndexInfo[r100.size()];
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        VotedIndexInfo r103 = (VotedIndexInfo) r102.next();
        r101[(int) r103.index.longValue()] = r103;
        goto L4
    L7:
        return ArraysKt.toList(r101);
    }

    public static ArrayList b(List r110, Map r111, Map r112) {
        ArrayList r100 = new ArrayList();
        if (r110 == null) goto L37;
        Iterator r113 = r110.iterator();
    L6:
        if (r113.hasNext() == false) goto L37;
        long r101 = ((Number) r113.next()).longValue();
        if (r111 == null) goto L37;
        Chatter r102 = (Chatter) r111.get(String.valueOf(r101));
        if (r102 == null) goto L37;
        String r103 = null;
        if (r112 == null) goto L15;
        Chatter r104 = (Chatter) r112.get(String.valueOf(r101));
    L16:
        String r105 = r102.name;
        boolean r106 = true;
        if (r105 != null) goto L19;
    L22:
        boolean r107 = true;
    L23:
        if (r107 == true) goto L25;
        String r108 = r102.name;
    L26:
        if (r108 != null) goto L28;
    L31:
        if (r106 == false) goto L35;
        if (r104 == null) goto L34;
        r103 = r104.name;
    L34:
        String r109 = r103;
    L36:
        r100.add(new VoteUser(String.valueOf(r101), r109, r102.avatar_key, r102.tenant_id, a0.a(r102.tag_info)));
        goto L6
    L35:
        r109 = r108;
        goto L36
    L28:
        if (r108.length() == 0) goto L31;
        r106 = false;
        goto L31
    L25:
        r108 = r102.alias;
        goto L26
    L19:
        if (r105.length() == 0) goto L22;
        r107 = false;
        goto L23
    L15:
        r104 = null;
    L37:
        return r100;
    }
}
