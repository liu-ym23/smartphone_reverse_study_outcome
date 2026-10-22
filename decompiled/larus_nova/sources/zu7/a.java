package zu7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.stats.WakeLockEvent;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes23.dex */
public final class a implements Parcelable.Creator {
    public a() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel r210) {
        int r100 = SafeParcelReader.validateObjectHeader(r210);
        String r110 = null;
        ArrayList<String> r111 = null;
        String r112 = null;
        String r113 = null;
        String r211 = null;
        String r212 = null;
        long r101 = 0;
        long r114 = 0;
        long r213 = 0;
        int r102 = 0;
        int r115 = 0;
        int r116 = 0;
        int r117 = 0;
        float r214 = 0.0f;
        boolean r215 = false;
    L4:
        if (r210.dataPosition() >= r100) goto L23;
        int r103 = SafeParcelReader.readHeader(r210);
        switch(SafeParcelReader.getFieldId(r103)) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L7;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L7;
            case 8: goto L17;
            case 9: goto L7;
            case 10: goto L16;
            case 11: goto L15;
            case 12: goto L14;
            case 13: goto L13;
            case 14: goto L12;
            case 15: goto L11;
            case 16: goto L10;
            case 17: goto L9;
            case 18: goto L8;
            default: goto L7;
        };
    L8:
        r215 = SafeParcelReader.readBoolean(r210, r103);
        goto L4
    L9:
        r212 = SafeParcelReader.createString(r210, r103);
        goto L4
    L10:
        r213 = SafeParcelReader.readLong(r210, r103);
        goto L4
    L11:
        r214 = SafeParcelReader.readFloat(r210, r103);
        goto L4
    L12:
        r117 = SafeParcelReader.readInt(r210, r103);
        goto L4
    L13:
        r211 = SafeParcelReader.createString(r210, r103);
        goto L4
    L14:
        r112 = SafeParcelReader.createString(r210, r103);
        goto L4
    L15:
        r115 = SafeParcelReader.readInt(r210, r103);
        goto L4
    L16:
        r113 = SafeParcelReader.createString(r210, r103);
        goto L4
    L17:
        r114 = SafeParcelReader.readLong(r210, r103);
        goto L4
    L18:
        r111 = SafeParcelReader.createStringList(r210, r103);
        goto L4
    L19:
        r116 = SafeParcelReader.readInt(r210, r103);
        goto L4
    L20:
        r110 = SafeParcelReader.createString(r210, r103);
        goto L4
    L21:
        r101 = SafeParcelReader.readLong(r210, r103);
        goto L4
    L22:
        r102 = SafeParcelReader.readInt(r210, r103);
        goto L4
    L7:
        SafeParcelReader.skipUnknownField(r210, r103);
        goto L4
    L23:
        SafeParcelReader.ensureAtEnd(r210, r100);
        return new WakeLockEvent(r102, r101, r115, r110, r116, r111, r112, r114, r117, r113, r211, r214, r213, r212, r215);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r100) {
        return new WakeLockEvent[r100];
    }
}
