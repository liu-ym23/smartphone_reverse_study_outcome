package kotlin.coroutines.jvm.internal;

import android.util.EventsUtils;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0006H\u0001\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\tH\u0001\u001a\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\fH\u0001\u001a\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000fH\u0001\u001a\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0012H\u0001\u001a\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0015H\u0001\u001a\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u0018H\u0001¨\u0006\u0019"}, d2 = {"boxBoolean", "Ljava/lang/Boolean;", "primitive", XmlPullParser.NO_NAMESPACE, "boxByte", "Ljava/lang/Byte;", XmlPullParser.NO_NAMESPACE, "boxChar", "Ljava/lang/Character;", XmlPullParser.NO_NAMESPACE, "boxDouble", "Ljava/lang/Double;", XmlPullParser.NO_NAMESPACE, "boxFloat", "Ljava/lang/Float;", XmlPullParser.NO_NAMESPACE, "boxInt", "Ljava/lang/Integer;", XmlPullParser.NO_NAMESPACE, "boxLong", "Ljava/lang/Long;", XmlPullParser.NO_NAMESPACE, "boxShort", "Ljava/lang/Short;", XmlPullParser.NO_NAMESPACE, "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class Boxing {
    public static final Boolean boxBoolean(boolean r0) {
        return Boolean.valueOf(r0);
    }

    public static final Byte boxByte(byte r0) {
        return Byte.valueOf(r0);
    }

    public static final Character boxChar(char r1) {
        return new Character(r1);
    }

    public static final Double boxDouble(double r1) {
        return new Double(r1);
    }

    public static final Float boxFloat(float r1) {
        return new Float(r1);
    }

    public static final Integer boxInt(int r1) {
        return new Integer(r1);
    }

    public static final Long boxLong(long r1) {
        return new Long(r1);
    }

    public static final Short boxShort(short r1) {
        return new Short(r1);
    }
}
