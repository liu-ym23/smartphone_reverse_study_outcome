package qs0;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.constants.EventConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public interface b {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lqs0/b$a;", "", "", "game_id", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "", EventConstants.ExtraJson.GAME_NAME, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "live-profile-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("game_id")
        private final long game_id;

        @SerializedName(EventConstants.ExtraJson.GAME_NAME)
        private final String game_name;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (this.game_id == r101.game_id) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.game_name, r101.game_name) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            long r100 = this.game_id;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            String r102 = this.game_name;
            if (r102 == null) goto L5;
            int r103 = r102.hashCode();
        L7:
            return r101 + r103;
        L5:
            r103 = 0;
            goto L7
        }

        public final String toString() {
            return "InteractGameExtra(game_id=" + this.game_id + ", game_name=" + this.game_name + ")";
        }

        public final long a() {
            return this.game_id;
        }

        public final String b() {
            return this.game_name;
        }

        public a(long r100, String r101) {
            this.game_id = r100;
            this.game_name = r101;
        }
    }

    a j();
}
