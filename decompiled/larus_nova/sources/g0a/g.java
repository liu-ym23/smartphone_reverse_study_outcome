package g0a;

import com.larus.ugc.feed.impl.ability.CreationFeedAbilityImpl;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes31.dex */
public interface g extends m1a.a {

    public static final class a {
        public static /* synthetic */ Object a(CreationFeedAbilityImpl r100, boolean r101, boolean r102, boolean r103, Continuation r104, int r105) {
            if ((r105 & 1) == 0) goto L6;
            r101 = false;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = false;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = false;
        L12:
            return r100.l(r101, r102, r103, r104);
        }
    }
}
