package com.obric.assistant;

import android.util.EventsUtils;
import com.google.gson.JsonObject;
import com.obric.aiagent.assistant.idl.bean.FeatureConfigMap;
import com.obric.aiagent.assistant.idl.bean.ObricMemoryDataCollectConfig;
import com.obric.assistant.settings.config.ModelSettingsConfig;
import com.obric.assistant.settings.config.ObricImageUploadCompressConfig;
import com.obric.assistant.settings.config.ObricMmtVideoHardwareConfig;
import com.obric.assistant.settings.voiceprint.g;
import com.obric.assistant.settings.voiceprint.v;
import com.obric.performance.power.monitor.constants.ObricPerformancePowerMonitorConfig;
import com.obric.performance.power.monitor.cpu.exception.CPUExceptionDiagnosisConfig;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000¢\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b5\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H&J\"\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00072\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH&J\b\u0010\u0010\u001a\u00020\u0007H'J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H'J\b\u0010\u0012\u001a\u00020\u0005H'J\u0012\u0010\u0013\u001a\u00020\t2\b\b\u0001\u0010\u0014\u001a\u00020\u0005H&J\b\u0010\u0015\u001a\u00020\u0007H'J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H'J\b\u0010\u0017\u001a\u00020\u0007H'J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H'J\b\u0010\u0019\u001a\u00020\u0005H'J\u0012\u0010\u001a\u001a\u00020\t2\b\b\u0001\u0010\u0014\u001a\u00020\u0005H&J\b\u0010\u001b\u001a\u00020\u0007H'J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H'J\b\u0010\u001d\u001a\u00020\u0007H&J\b\u0010\u001e\u001a\u00020\u0005H'J\u0012\u0010\u001f\u001a\u00020\t2\b\b\u0001\u0010\u0014\u001a\u00020\u0005H'J\b\u0010 \u001a\u00020\u0007H'J\b\u0010!\u001a\u00020\u0005H'J\u0012\u0010\"\u001a\u00020\t2\b\b\u0001\u0010\u0014\u001a\u00020\u0005H'J\b\u0010#\u001a\u00020\u0007H'J\b\u0010$\u001a\u00020\u0005H'J\u0012\u0010%\u001a\u00020\t2\b\b\u0001\u0010\u0014\u001a\u00020\u0005H&J\b\u0010&\u001a\u00020\u0007H&J\b\u0010'\u001a\u00020\u0005H'J\u0012\u0010(\u001a\u00020\t2\b\b\u0001\u0010\u0014\u001a\u00020\u0005H&J\b\u0010)\u001a\u00020\u0007H&J\b\u0010*\u001a\u00020\u0005H'J\u0012\u0010+\u001a\u00020\t2\b\b\u0001\u0010\u0014\u001a\u00020\u0005H&J\b\u0010,\u001a\u00020\u0007H&J\b\u0010-\u001a\u00020\u0007H&J\b\u0010.\u001a\u00020\tH&J\b\u0010/\u001a\u00020\u0007H&J\b\u00100\u001a\u00020\tH&J\b\u00101\u001a\u00020\tH&J\b\u00102\u001a\u00020\tH&J!\u00103\u001a\u00020\t2\b\u00104\u001a\u0004\u0018\u00010\u00052\b\u00105\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0002\u00106J\b\u00107\u001a\u00020\u0007H&J\u0010\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\u0007H&J\b\u0010:\u001a\u00020\u0007H&J\u0010\u0010;\u001a\u00020\t2\u0006\u00109\u001a\u00020\u0007H&J\b\u0010<\u001a\u00020\u0007H&J\u0010\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\u0007H&J\b\u0010?\u001a\u00020\u0007H&J\u0010\u0010@\u001a\u00020\t2\u0006\u0010A\u001a\u00020\u0007H&J\b\u0010B\u001a\u00020\u0007H&J\b\u0010C\u001a\u00020\tH&J \u0010C\u001a\u00020\t2\u0016\b\u0002\u0010D\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t\u0018\u00010EH&J\b\u0010F\u001a\u00020\tH&J\b\u0010G\u001a\u00020\tH&J\u0010\u0010H\u001a\u00020\t2\u0006\u0010I\u001a\u00020\u0007H&J\b\u0010J\u001a\u00020\u0007H&J\b\u0010K\u001a\u00020\u0007H&J\b\u0010L\u001a\u00020\tH&J\u0010\u0010M\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u000fH&J\u001a\u0010O\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0P0\u000eH&J\u000e\u0010Q\u001a\b\u0012\u0004\u0012\u00020R0\u000eH&J\u0018\u0010S\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u000f2\u0006\u0010T\u001a\u00020\u000fH&J\u0010\u0010U\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u000fH&J(\u0010U\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u000f2\u0016\b\u0002\u0010D\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t\u0018\u00010EH&J\b\u0010V\u001a\u00020\u0007H&J\b\u0010W\u001a\u00020\u0007H&J$\u0010X\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010Yj\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001`ZH&J\b\u0010[\u001a\u00020\u0007H&J\u0010\u0010\\\u001a\u00020\t2\u0006\u00109\u001a\u00020\u0007H&J\b\u0010]\u001a\u00020\u0007H&J\u0010\u0010^\u001a\u00020\t2\u0006\u00109\u001a\u00020\u0007H&J\b\u0010_\u001a\u00020\u0007H&J\u0010\u0010`\u001a\u00020\t2\u0006\u00109\u001a\u00020\u0007H&J\b\u0010a\u001a\u00020\u0007H&J\u0010\u0010b\u001a\u00020\t2\u0006\u00109\u001a\u00020\u0007H&J\b\u0010c\u001a\u00020\u0007H&J\u0010\u0010d\u001a\u00020\t2\u0006\u00109\u001a\u00020\u0007H&J\b\u0010e\u001a\u00020\u0005H&J\u0010\u0010f\u001a\u00020\t2\u0006\u0010g\u001a\u00020\u0005H&J\b\u0010h\u001a\u00020\u0007H&J\b\u0010i\u001a\u00020\u0007H&J\b\u0010j\u001a\u00020\u0007H&J\u000f\u0010k\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010lJ\n\u0010m\u001a\u0004\u0018\u00010\u0001H&J\u0017\u0010n\u001a\u00020\t2\b\u0010o\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010pJ\u0012\u0010q\u001a\u00020\t2\b\u0010r\u001a\u0004\u0018\u00010\u0001H&J\u0010\u0010s\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H&J\b\u0010t\u001a\u00020\u0007H&J\u0010\u0010u\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H&J\b\u0010v\u001a\u00020\u0007H&J\b\u0010w\u001a\u00020\u000fH&J\u0010\u0010x\u001a\u00020\t2\u0006\u0010y\u001a\u00020\u000fH&J\u0010\u0010z\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H&J\b\u0010{\u001a\u00020\u0007H&J\b\u0010|\u001a\u00020\u0007H&J\u0010\u0010}\u001a\u00020\t2\u0006\u0010~\u001a\u00020\u0005H&J\b\u0010\u007f\u001a\u00020\u0005H&J\t\u0010\u0080\u0001\u001a\u00020\u0007H&J\u0012\u0010\u0081\u0001\u001a\u00020\t2\u0007\u0010\u0082\u0001\u001a\u00020\u0007H&J\t\u0010\u0083\u0001\u001a\u00020\u0007H&J\u0013\u0010\u0084\u0001\u001a\u00020\t2\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H&J\n\u0010\u0087\u0001\u001a\u00030\u0086\u0001H&J\u0012\u0010\u0088\u0001\u001a\u00020\t2\u0007\u0010\u0089\u0001\u001a\u00020\u0007H&J\t\u0010\u008a\u0001\u001a\u00020\u0007H&J\t\u0010\u008b\u0001\u001a\u00020\u000fH'J\u0013\u0010\u008c\u0001\u001a\u00020\t2\b\b\u0001\u0010y\u001a\u00020\u000fH&J\u001b\u0010\u008d\u0001\u001a\u00020\u000f2\u0007\u0010\u008e\u0001\u001a\u00020\u000f2\u0007\u0010\u008f\u0001\u001a\u00020\u000fH&J\u0016\u0010\u0090\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0091\u0001H&J\u001b\u0010\u0092\u0001\u001a\u00020\t2\u0007\u0010\u008e\u0001\u001a\u00020\u000f2\u0007\u0010\u0093\u0001\u001a\u00020\u000fH&J\t\u0010\u0094\u0001\u001a\u00020\u0007H&J\t\u0010\u0095\u0001\u001a\u00020\u0005H&J\t\u0010\u0096\u0001\u001a\u00020\u0005H&J\t\u0010\u0097\u0001\u001a\u00020\u0005H&J\u0011\u0010\u0098\u0001\u001a\u00020\t2\u0006\u0010g\u001a\u00020\u0005H&J\u0011\u0010\u0099\u0001\u001a\u00020\t2\u0006\u00109\u001a\u00020\u0007H&J\t\u0010\u009a\u0001\u001a\u00020\u0007H&J\u0011\u0010\u009b\u0001\u001a\u00020\t2\u0006\u00109\u001a\u00020\u0007H&J\t\u0010\u009c\u0001\u001a\u00020\u0007H&J\t\u0010\u009d\u0001\u001a\u00020\u0007H&J\t\u0010\u009e\u0001\u001a\u00020\tH&J\u0012\u0010\u009f\u0001\u001a\u00020\t2\u0007\u0010 \u0001\u001a\u00020\u000fH&J\t\u0010¡\u0001\u001a\u00020\u000fH&J\u0012\u0010¢\u0001\u001a\u00020\t2\u0007\u0010£\u0001\u001a\u00020\u000fH&J\t\u0010¤\u0001\u001a\u00020\u000fH&J\u0011\u0010¥\u0001\u001a\u00020\t2\u0006\u0010g\u001a\u00020\u0005H&J\t\u0010¦\u0001\u001a\u00020\u0005H&J\n\u0010§\u0001\u001a\u00030¨\u0001H&J\u0012\u0010©\u0001\u001a\u00020\u00052\u0007\u0010ª\u0001\u001a\u00020\u000fH&J\u001a\u0010«\u0001\u001a\u00020\t2\u0007\u0010ª\u0001\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u0007H&J\u0012\u0010¬\u0001\u001a\u00020\t2\u0007\u0010ª\u0001\u001a\u00020\u000fH&J\t\u0010\u00ad\u0001\u001a\u00020\u0005H&J\u0011\u0010®\u0001\u001a\u00020\t2\u0006\u0010g\u001a\u00020\u0005H&J\n\u0010¯\u0001\u001a\u00030\u0086\u0001H&J\u0013\u0010°\u0001\u001a\u00020\t2\b\u0010±\u0001\u001a\u00030\u0086\u0001H&J\t\u0010²\u0001\u001a\u00020\u0005H&J\u0012\u0010³\u0001\u001a\u00020\t2\u0007\u0010´\u0001\u001a\u00020\u0005H&J\n\u0010µ\u0001\u001a\u00030\u0086\u0001H&J\u0013\u0010¶\u0001\u001a\u00020\t2\b\u0010±\u0001\u001a\u00030\u0086\u0001H&J\n\u0010·\u0001\u001a\u00030\u0086\u0001H&J\u0013\u0010¸\u0001\u001a\u00020\t2\b\u0010±\u0001\u001a\u00030\u0086\u0001H&J\n\u0010¹\u0001\u001a\u00030º\u0001H&J\n\u0010»\u0001\u001a\u00030¼\u0001H&J\n\u0010½\u0001\u001a\u00030¾\u0001H&J\n\u0010¿\u0001\u001a\u00030À\u0001H&J\n\u0010Á\u0001\u001a\u00030Â\u0001H&J\u0012\u0010Ã\u0001\u001a\u00020\t2\u0007\u0010£\u0001\u001a\u00020\u000fH&J\t\u0010Ä\u0001\u001a\u00020\u000fH&J\n\u0010Å\u0001\u001a\u00030Æ\u0001H&J\n\u0010Ç\u0001\u001a\u00030È\u0001H&J\n\u0010É\u0001\u001a\u00030Ê\u0001H&J\n\u0010Ë\u0001\u001a\u00030Ì\u0001H&J\u0018\u0010Í\u0001\u001a\u00030Î\u00012\f\b\u0002\u0010Ï\u0001\u001a\u0005\u0018\u00010Ð\u0001H&J\n\u0010Ñ\u0001\u001a\u00030Ò\u0001H&J\t\u0010Ó\u0001\u001a\u00020\u0007H&J\n\u0010Ô\u0001\u001a\u00030Õ\u0001H&J\n\u0010Ö\u0001\u001a\u00030×\u0001H&J\n\u0010Ø\u0001\u001a\u00030Ù\u0001H&J\n\u0010Ú\u0001\u001a\u00030Û\u0001H&J\n\u0010Ü\u0001\u001a\u00030Ý\u0001H&J\n\u0010Þ\u0001\u001a\u00030ß\u0001H&J\n\u0010à\u0001\u001a\u00030á\u0001H&J\n\u0010â\u0001\u001a\u00030ã\u0001H&J\n\u0010ä\u0001\u001a\u00030å\u0001H&J\n\u0010æ\u0001\u001a\u00030ç\u0001H&J\n\u0010è\u0001\u001a\u00030é\u0001H&J\f\u0010ê\u0001\u001a\u0005\u0018\u00010ë\u0001H&J\t\u0010ì\u0001\u001a\u00020\u000fH&J\t\u0010í\u0001\u001a\u00020\u0007H&J\u0012\u0010î\u0001\u001a\u00020\t2\u0007\u0010ï\u0001\u001a\u00020\u000fH&J\t\u0010ð\u0001\u001a\u00020\u000fH&J\t\u0010ñ\u0001\u001a\u00020\tH&J\t\u0010ò\u0001\u001a\u00020\u0007H&J\u0011\u0010ó\u0001\u001a\u00020\t2\u0006\u00109\u001a\u00020\u0007H&J\t\u0010ô\u0001\u001a\u00020\u0007H&J\u0011\u0010õ\u0001\u001a\u00020\t2\u0006\u00109\u001a\u00020\u0007H&J\n\u0010ö\u0001\u001a\u00030÷\u0001H&J\n\u0010ø\u0001\u001a\u00030ù\u0001H&J\u0014\u0010ú\u0001\u001a\u00020\u000f2\t\u0010û\u0001\u001a\u0004\u0018\u00010\u000fH&J\f\u0010ü\u0001\u001a\u0005\u0018\u00010ý\u0001H&J\n\u0010þ\u0001\u001a\u00030ÿ\u0001H&J\n\u0010\u0080\u0002\u001a\u00030\u0081\u0002H&J\n\u0010\u0082\u0002\u001a\u00030\u0083\u0002H&J\n\u0010\u0084\u0002\u001a\u00030\u0085\u0002H&J\n\u0010\u0086\u0002\u001a\u00030\u0081\u0002H&J\n\u0010\u0087\u0002\u001a\u00030\u0088\u0002H&J\n\u0010\u0089\u0002\u001a\u00030\u008a\u0002H&J\t\u0010\u008b\u0002\u001a\u00020\u0007H&J\t\u0010\u008c\u0002\u001a\u00020\u0007H&J\t\u0010\u008d\u0002\u001a\u00020\u0007H&J\t\u0010\u008e\u0002\u001a\u00020\u0007H&J\n\u0010\u008f\u0002\u001a\u00030\u0090\u0002H&J\t\u0010\u0091\u0002\u001a\u00020\u0005H&J\t\u0010\u0092\u0002\u001a\u00020\u000fH&J\u0012\u0010\u0093\u0002\u001a\u00020\t2\u0007\u0010\u0094\u0002\u001a\u00020\u000fH&J\u0015\u0010\u0095\u0002\u001a\u0005\u0018\u00010ý\u00012\u0007\u0010ª\u0001\u001a\u00020\u000fH&J\t\u0010\u0096\u0002\u001a\u00020\u0007H&J\n\u0010\u0097\u0002\u001a\u00030\u0098\u0002H&J\n\u0010\u0099\u0002\u001a\u00030\u009a\u0002H&J\n\u0010\u009b\u0002\u001a\u00030\u009c\u0002H&J\n\u0010\u009d\u0002\u001a\u00030\u009e\u0002H&J\t\u0010\u009f\u0002\u001a\u00020\u0007H&J\u0011\u0010 \u0002\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H&J\u0011\u0010¡\u0002\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H&J\t\u0010¢\u0002\u001a\u00020\u0007H&J\t\u0010£\u0002\u001a\u00020\u0007H&J\t\u0010¤\u0002\u001a\u00020\u0007H&J\t\u0010¥\u0002\u001a\u00020\u0007H&J\u0011\u0010¦\u0002\u001a\u00020\t2\u0006\u00109\u001a\u00020\u0007H&J\t\u0010§\u0002\u001a\u00020\u0007H&J\u0011\u0010¨\u0002\u001a\u00020\t2\u0006\u00109\u001a\u00020\u0007H&J\t\u0010©\u0002\u001a\u00020\u0005H&J\u0011\u0010ª\u0002\u001a\u00020\t2\u0006\u0010~\u001a\u00020\u0005H&J\t\u0010«\u0002\u001a\u00020\u000fH&J\t\u0010¬\u0002\u001a\u00020\u0007H&J\u0012\u0010\u00ad\u0002\u001a\u00020\t2\u0007\u0010®\u0002\u001a\u00020\u0007H&J\n\u0010¯\u0002\u001a\u00030°\u0002H&J\u0012\u0010±\u0002\u001a\u00020\t2\u0007\u0010²\u0002\u001a\u00020\u0007H&J\t\u0010³\u0002\u001a\u00020\u0007H&J\t\u0010´\u0002\u001a\u00020\u0007H&J\u0011\u0010µ\u0002\u001a\u00020\t2\u0006\u0010>\u001a\u00020\u0007H&J\u0014\u0010¶\u0002\u001a\u00020\u00072\t\u0010·\u0002\u001a\u0004\u0018\u00010\u000fH&J\u001d\u0010¸\u0002\u001a\u00020\t2\t\u0010·\u0002\u001a\u0004\u0018\u00010\u000f2\u0007\u0010¹\u0002\u001a\u00020\u0007H&J\n\u0010º\u0002\u001a\u00030»\u0002H&J\t\u0010¼\u0002\u001a\u00020\u0007H&J\u0011\u0010½\u0002\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H&J\t\u0010¾\u0002\u001a\u00020\u0007H&J\u0011\u0010¿\u0002\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H&J\u0014\u0010À\u0002\u001a\u00030\u0086\u00012\b\b\u0001\u0010g\u001a\u00020\u0005H'J\u001f\u0010Á\u0002\u001a\u00020\t2\b\b\u0001\u0010g\u001a\u00020\u00052\n\b\u0001\u0010Â\u0002\u001a\u00030\u0086\u0001H&J\t\u0010Ã\u0002\u001a\u00020\u0007H&J\t\u0010Ä\u0002\u001a\u00020\u0007H&J\u0011\u0010Å\u0002\u001a\u00020\t2\u0006\u00109\u001a\u00020\u0007H&J\n\u0010Æ\u0002\u001a\u00030Ç\u0002H&J\n\u0010È\u0002\u001a\u00030É\u0002H&J\n\u0010Ê\u0002\u001a\u00030Ë\u0002H&J\n\u0010Ì\u0002\u001a\u00030Í\u0002H&J\n\u0010Î\u0002\u001a\u00030Ï\u0002H&J\n\u0010Ð\u0002\u001a\u00030Ñ\u0002H&J\n\u0010Ò\u0002\u001a\u00030Ó\u0002H&J\t\u0010Ô\u0002\u001a\u00020\u0007H&J\u0011\u0010Õ\u0002\u001a\u00020\t2\u0006\u0010>\u001a\u00020\u0007H&J\t\u0010Ö\u0002\u001a\u00020\tH&J\u0013\u0010×\u0002\u001a\u00020\t2\b\u0010Ø\u0002\u001a\u00030Ù\u0002H&J\u0013\u0010Ú\u0002\u001a\u00020\t2\b\u0010Ø\u0002\u001a\u00030Ù\u0002H&J\t\u0010Û\u0002\u001a\u00020\u0007H&J\t\u0010Ü\u0002\u001a\u00020\u0007H&¨\u0006Ý\u0002"}, d2 = {"Lcom/obric/assistant/IObricSettingsApi;", XmlPullParser.NO_NAMESPACE, "getMmtVideoHardwareConfig", "Lcom/obric/assistant/settings/config/ObricMmtVideoHardwareConfig;", "getObricPrivacyLaneType", XmlPullParser.NO_NAMESPACE, "isLockedScreenUseEnabled", XmlPullParser.NO_NAMESPACE, "saveLockedScreenUseEnabled", XmlPullParser.NO_NAMESPACE, "enable", "saveVoicePrintAuthenticationTypeForLockedUseSettings", "isSetDefaultSettingItems", "currentSettingItems", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "isNewTopicLockedEnabled", "saveNewTopicLockedEnabled", "getAuthenticationTypeOfChatAndOnlineQAOnLockScreen", "saveAuthenticationTypeOfChatAndOnlineQAOnLockScreen", "type", "isAutoGuiExecuteOnLockScreenEnabled", "saveAutoGuiExecuteOnLockScreenEnabled", "isVoicePrintAuthenticateAutoGuiEnabled", "setVoicePrintAuthenticateAutoGuiEnabled", "getAuthenticationTypeOfAutoGuiExecuteOnLockScreen", "saveAuthenticationTypeOfAutoGuiExecuteOnLockScreen", "isVoicePrintAuthenticateOnLockScreenEnabled", "saveVoicePrintAuthenticateOnLockScreenEnabled", "showVoicePrintAuthenticateAutoGuiEnabledRedPot", "getAuthenticationTypeOfGlobalMemoryAccessOnLockScreen", "saveAuthenticationTypeOfGlobalMemoryAccessOnLockScreen", "isUserHasSetAuthenticationTypeOfGlobalMemoryAccessOnLockScreen", "getAuthenticationTypeOfPersonalInfoAccessOnLockScreen", "saveAuthenticationTypeOfPersonalInfoAccessOnLockScreen", "isUserHasSetAuthenticationTypeOfPersonalInfoAccessOnLockScreen", "getAuthenticationTypeOfChatHistoryAccessOnLockScreen", "saveAuthenticationTypeOfChatHistoryAccessOnLockScreen", "isUserHasSetAuthenticationTypeOfChatHistoryAccessOnLockScreen", "getAuthenticationTypeOfLocalAppDataAccessOnLockScreen", "saveAuthenticationTypeOfLocalAppDataAccessOnLockScreen", "isUserHasSetAuthenticationTypeOfLocalAppDataAccessOnLockScreen", "getAuthenticationTypeOfSimpleCommandExecuteOnLockScreen", "saveAuthenticationTypeOfSimpleCommandExecuteOnLockScreen", "isUserHasSetAuthenticationTypeOfSimpleCommandExecuteOnLockScreen", "isUserGuideTipsShown", "setUserGuideTipsShown", "isMainBotIconEnabled", "enableMainBotIcon", "disableMainBotIcon", "preparePendingAction", "executePendingAction", "currentSelectAppIconId", "cvsId", "(Ljava/lang/Integer;Ljava/lang/String;)V", "isVoiceWakeupEnabled", "setVoiceWakeupEnabled", "enabled", "isImproveVoiceWakeupEnabled", "setImproveVoiceWakeupEnabled", "isVoiceWakeupImproveNotificationShown", "setVoiceWakeupImproveNotificationShown", "shown", "isVoiceNoiseReductionUpgradeNoticeAcknowledged", "setVoiceNoiseReductionUpgradeNoticeAcknowledged", "acknowledged", "isVoicePrintExisted", "clearVoicePrint", "callback", "Lkotlin/Function1;", "uploadDefaultVoicePrintToCloud", "deleteDefaultVoicePrintFromCloud", "setDefaultVoicePrintTrainable", "isTrainable", "isDefaultVoicePrintUploadedToCloud", "isDefaultVoicePrintRecordedWithMic0Flow", "resetLockedUseAuthenticationTypeWhenVoicePrintDeleted", "getDeviceEnrollStatus", "macId", "getEnrolledDevices", "Lkotlin/Pair;", "getEnrolledDeviceInfos", "Lcom/obric/assistant/ObricEnrolledDeviceInfo;", "updateEnrolledDeviceName", "newName", "deleteEnrolledDevice", "isCheckUpdateDialogEnabled", "isCheckUpdateEntryEnabled", "obricPluginsConfig", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "isMemoryEnabled", "saveMemoryEnabled", "isTtsPlayBackgroundEnabled", "setTtsPlayBackgroundEnabled", "isSemanticScreenShotEnabled", "setSemanticScreenShotEnabled", "isAutoImageUploadEnabled", "setAutoImageUploadEnabled", "isAutoImageUploadEnabledInPrivacy", "setAutoImageUploadEnabledInPrivacy", "getAutoGuiEnabledScene", "setAutoGuiEnabledScene", "scene", "isPhoneOperationNormalFileUploadSupported", "isPhoneOperationSpecialFileUploadSupported", "isPhoneOperationOnlyAttachmentSendSupported", "getObricDefaultReplyMode", "()Ljava/lang/Integer;", "getObricDefaultReplyModeOption", "setObricDefaultReplyMode", "itemId", "(Ljava/lang/Integer;)V", "setObricDefaultReplyOption", "option", "setOUseMemoryEnabled", "getOUseMemoryEnabled", "setOUseClipboardEnabled", "getOUseClipboardEnabled", "getAutoGuiFastModeUseSettings", "setAutoGuiFastModeUseSettings", "value", "setSkillExtensionEnabled", "getSkillExtensionEnabled", "hasSkillExtensionEnabledCache", "setOmniSkillAvailableState", "state", "getOmniSkillAvailableState", "isOmniSkillUsable", "setSkillExtensionActionBarNewHasTriggered", "triggered", "getSkillExtensionActionBarNewHasTriggered", "setSkillExtensionActionBarNewExpireAtMs", "expireAtMs", XmlPullParser.NO_NAMESPACE, "getSkillExtensionActionBarNewExpireAtMs", "setSkillExtensionActionBarNewConsumed", "consumed", "getSkillExtensionActionBarNewConsumed", "getRiskPreferenceSettings", "setRiskPreferenceSettings", "getAutoExecuteAuthorizationStatus", "authorizationKey", "defaultValue", "getAutoExecuteAuthorizationStatusMap", XmlPullParser.NO_NAMESPACE, "setAutoExecuteAuthorizationStatus", "status", "isPersonalContextOpened", "getObricPowerLockTimeoutInSeconds", "getObricKeepFrontierAliveLoopIntervalInSeconds", "getObricIntentUploadStrategyForDebug", "setObricIntentUploadStrategyForDebug", "setDoubaoWhisperEnabled", "isDoubaoWhisperEnabled", "setDoubaoWhisperDataUploadEnabled", "isDoubaoWhisperDataUploadEnabled", "isNotFirstDoubaoWhisperEnabled", "setFirstDoubaoWhisperEnableFinished", "setComplexTaskMode", "mode", "getComplexTaskMode", "setComplexTaskLlmModel", "model", "getComplexTaskLlmModel", "setComplexTaskLocalSearchEnabled", "getComplexTaskLocalSearchEnabledScene", "getComplexTaskSettingsConfig", "Lcom/obric/assistant/ComplexTaskSettingsConfig;", "getTtsPlayOptionEnable", "key", "setTtsPlayOptionEnable", "clearTtsPlayOptionEnable", "getObricComplexTaskIslandStrategyForDebug", "setObricComplexTaskIslandStrategyForDebug", "getObricPerformanceMonitorKillTime", "setObricPerformanceMonitorKillTime", "timeMillis", "getObricLocalSettingsVersion", "setObricLocalSettingsVersion", "version", "getObricSettingsCheckTime", "setObricSettingsCheckTime", "getObricSettingsPullTime", "setObricSettingsPullTime", "getSelfUpdateSettingsConfig", "Lcom/obric/assistant/SelfUpdateSettingsConfig;", "getUpdateSettingsConfig", "Lcom/obric/assistant/UpdateSettingsConfig;", "getSecuritySettingsConfig", "Lcom/obric/assistant/SecuritySettingsConfig;", "getObricSecuritySettingsPackageWhitelistConfig", "Lcom/obric/assistant/ObricSecuritySettingsPackageWhitelistConfig;", "getFeatureConfigMap", "Lcom/obric/aiagent/assistant/idl/bean/FeatureConfigMap;", "setCurrentModel", "getCurrentModel", "getModelSettingsConfig", "Lcom/obric/assistant/settings/config/ModelSettingsConfig;", "getVoicePrintAuthenticateSettingsConfig", "Lcom/obric/assistant/VoicePrintAuthenticateSettingsConfig;", "getQueryAuthenticateConfig", "Lcom/obric/assistant/QueryAuthenticateConfig;", "getObricComplexTaskCaseFromPC", "Lcom/obric/assistant/ComplexTaskCaseFromPCConfig;", "getObricSettingsListConfig", "Lcom/obric/assistant/ObricSettingsListConfig;", "appSettings", "Lorg/json/JSONObject;", "getObricOneLoginConfig", "Lcom/obric/assistant/ObricOneLoginConfig;", "enableObricSettingsOverride", "getObricAutoIncreaseDelayedTimeConfig", "Lcom/obric/assistant/AutoIncreaseDelayedTimeConfig;", "getObricProcessesManagerConfig", "Lcom/obric/assistant/ObricProcessesManagerConfig;", "getObricAppLogSettingsConfig", "Lcom/obric/assistant/ObricAppLogSettingsConfig;", "getObricLogSettingsConfig", "Lcom/obric/assistant/ObricLogSettingsConfig;", "getObricAiKeyConfig", "Lcom/obric/assistant/ObricAiKeyConfig;", "getObricPerformanceMonitorConfig", "Lcom/obric/assistant/ObricPerformanceMonitorConfig;", "getObricMemoryReportConfig", "Lcom/obric/assistant/ObricMemoryReportConfig;", "getObricThresholdDumpHprofConfig", "Lcom/obric/assistant/ObricThresholdDumpHprofConfig;", "getObricThreshlodPssUploadFilesConfig", "Lcom/obric/assistant/ObricThresholdPssUploadFilesConfig;", "getObricCrashDumpHprofConfig", "Lcom/obric/assistant/ObricCrashDumpHprofConfig;", "getObricSettingsConfig", "Lcom/obric/assistant/ObricSettingsConfig;", "getObricBreathWakeupDataTracker", "Lcom/obric/assistant/BreathWakeupDataTrackerConfig;", "getVoiceWakeupSidThresholdConfigForCurrentModel", "isBypassAdaptiveSid", "setDeviceUUID", "duid", "getDeviceUUID", "resetDeviceUUID", "isPcInAsrEnabled", "setPcInAsrEnabled", "isPcInAsrPolicyAgreed", "setPcInAsrPolicyAgreed", "getObricAutoGuiBlacklistConfig", "Lcom/obric/assistant/AutoGuiBlacklistConfig;", "getAutoGuiAppScopeConfig", "Lcom/obric/assistant/AutoGuiAppScopeConfig;", "getObricFlowSettingsJson", "settingKey", "getOAutoSettings", "Lcom/google/gson/JsonObject;", "getObricTaskTimeoutConfig", "Lcom/obric/assistant/ObricTimeoutConfig;", "getObricActionBarItemsConfig", "Lcom/obric/assistant/ObricActionBarItemsConfig;", "getObricActionBarModelMenuConfig", "Lcom/obric/assistant/ObricActionBarModelMenuConfig;", "getObricBottomTabConfig", "Lcom/obric/assistant/ObricBottomTabConfig;", "getWindowActionBarItemsConfig", "getObricDeepThinkModeRestTimeConfig", "Lcom/obric/assistant/ObricDeepThinkModeRestTimeConfig;", "getObricPromptCellConfig", "Lcom/obric/assistant/ObricPromptCellConfig;", "isAsrFeedbackEnable", "isContTalkSwitchShowEnable", "isObricContTalkPvadSwitchShowEnable", "isReRecordWakeWordGuideEnable", "getWakeupSoundConfig", "Lcom/obric/assistant/ObricWakeupSoundConfig;", "getWakeupSoundConfigWhite", "getSelectedWakeupSoundId", "setSelectedWakeupSoundId", "soundId", "getObricCloudConfig", "isObricDoraGNewDeviceManageEnable", "getObricMemoryDataCollectConfig", "Lcom/obric/aiagent/assistant/idl/bean/ObricMemoryDataCollectConfig;", "getObricPowerLockConfig", "Lcom/obric/assistant/ObricPowerLockConfig;", "getObricStateMachineMultitaskConfig", "Lcom/obric/assistant/ObricStateMachineMultitaskConfig;", "getObricAigcGenerationStateConfig", "Lcom/obric/assistant/ObricAigcGenerationStateConfig;", "isLarkKnowledgeAuthorizationEnable", "setLarkKnowledgeAuthorizationEnable", "saveAlwaysRespondToVoiceWakeup", "isAlwaysRespondToVoiceWakeup", "isDoraFeatureEnable", "isDoraSettingEntranceDegrade", "isConversationContentModelTrainingEnable", "setConversationContentModelTrainingEnable", "isUserExperiencePlanEnabled", "setUserExperiencePlanEnabled", "getStartAsDefaultAssistant", "setStartAsDefaultAssistant", "getVoiceWakeupStage1UserConfig", "isSecurityCertificateReady", "setSecurityCertificateReady", "ready", "getObricLarkConfirmSettingsConfig", "Lcom/obric/assistant/ObricLarkConfirmConfig;", "setObricMinorModeInstructionsReadByUser", "alreadyRead", "getObricMinorModeInstructionsReadByUser", "isBatchRequestInitPermissionDialogShown", "setBatchRequestInitPermissionDialogShown", "isEnterpriseAccountTipNeverShow", "personalUid", "setEnterpriseAccountTipNeverShow", "neverShow", "getObricScreenshotUploadConfig", "Lcom/obric/assistant/ObricScreenshotUploadConfig;", "isContinueSpeakEnable", "setContinueSpeakerEnabled", "isContinueSpeakNoiseReductionEnable", "setContinueSpeakNoiseReductionEnabled", "getAutoEndConversationTime", "setAutoEndConversationTime", "time", "isObricGazeKeepDisplaySupported", "isObricGazeKeepDisplayEnabled", "setObricGazeKeepDisplayEnabled", "getObricImageUploadCompressConfig", "Lcom/obric/assistant/settings/config/ObricImageUploadCompressConfig;", "getObricAppIntentScreenshotCacheConfig", "Lcom/obric/assistant/ObricAppIntentScreenshotCacheConfig;", "getObricAIagentNetworkInterceptConfig", "Lcom/obric/assistant/ObricAIagentNetworkInterceptConfig;", "getObricZeusAutoFetchConfig", "Lcom/obric/assistant/ZeusAutoFetchConfig;", "getObricLazyInitConfig", "Lcom/obric/assistant/ObricLazyInitConfig;", "getObricPerformancePowerMonitorSettingsConfig", "Lcom/obric/performance/power/monitor/constants/ObricPerformancePowerMonitorConfig;", "getObricPerformanceCPUExceptionDiagnosisSettingsConfig", "Lcom/obric/performance/power/monitor/cpu/exception/CPUExceptionDiagnosisConfig;", "isVoicePrintManagementRedPotShown", "setVoicePrintManagementRedPotShown", "registerMessageExt", "registerSettingsChangedListener", "listener", "Lcom/obric/assistant/IOnObricSettingsChangedListener;", "unregisterSettingsChangedListener", "isCloseAudioConnAppBackGroundOnlyForObric", "isVoiceSectionTrackerEnableSlardar", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface IObricSettingsApi {
    void A(long r1);

    void A0();

    int A1();

    boolean B();

    void B0(m r1);

    void B1(boolean r1);

    void C(String r1, boolean r2);

    void C0(Integer r1);

    void C1(Integer r1, String r2);

    void D(String r1);

    void D0(boolean r1);

    boolean D1();

    void E(long r1);

    void E0();

    long E1();

    void F(@ObricSettingsAuthenticationType int r1);

    void F0(@ObricSettingsAuthenticationType int r1);

    void F1(@ObricSettingsAuthenticationType int r1);

    long G();

    boolean G0();

    @Deprecated(message = "use getAuthenticationTypeOfAutoGuiExecuteOnLockScreen instead")
    boolean G1();

    int H();

    void H0(boolean r1);

    void H1(String r1);

    boolean I();

    SecuritySettingsConfig I0();

    boolean I1();

    void J(String r1);

    boolean J0();

    void J1();

    void K(boolean r1);

    boolean K0();

    boolean K1();

    String L();

    UpdateSettingsConfig L0();

    void L1(long r1);

    int M();

    void M0(String r1);

    @AutoEndConversationTime
    long M1(@AutoEndConversationScene int r1);

    boolean N();

    ObricThresholdPssUploadFilesConfig N0();

    long N1();

    @RiskPreferenceSettings
    String O();

    int O0();

    void O1(Object r1);

    boolean P();

    boolean P0();

    String P1(String r1, String r2);

    String Q();

    boolean Q0();

    @ObricSettingsAuthenticationType
    int Q1();

    ObricSettingsListConfig R(JSONObject r1);

    void R0(boolean r1);

    boolean R1();

    JsonObject S();

    void S0(m r1);

    boolean S1();

    boolean T();

    int T0();

    void T1(@AutoEndConversationScene int r1, @AutoEndConversationTime long r2);

    void U();

    void U0(boolean r1);

    void U1(String r1);

    void V(boolean r1);

    void V0(@ObricSettingsAuthenticationType int r1);

    boolean V1();

    @ObricSettingsAuthenticationType
    int W();

    void W0();

    boolean W1();

    void X(String r1, String r2);

    void X0();

    boolean Y();

    ModelSettingsConfig Y0();

    String Z();

    long Z0();

    boolean a(String r1);

    BreathWakeupDataTrackerConfig a0();

    void a1();

    boolean b();

    void b0();

    void b1();

    boolean c();

    boolean c0();

    void c1(boolean r1);

    boolean d();

    String d0();

    int d1();

    void e(v r1);

    int e0();

    @ObricSettingsAuthenticationType
    int e1();

    boolean enableObricSettingsOverride();

    void f(boolean r1);

    String f0();

    void f1(boolean r1);

    void g();

    boolean g0();

    void g1(boolean r1);

    Map<String, String> getAutoExecuteAuthorizationStatusMap();

    int getAutoGuiEnabledScene();

    String getAutoGuiFastModeUseSettings();

    FeatureConfigMap getFeatureConfigMap();

    ObricMmtVideoHardwareConfig getMmtVideoHardwareConfig();

    boolean getOUseMemoryEnabled();

    ObricActionBarItemsConfig getObricActionBarItemsConfig();

    ObricActionBarModelMenuConfig getObricActionBarModelMenuConfig();

    ObricAiKeyConfig getObricAiKeyConfig();

    ObricAigcGenerationStateConfig getObricAigcGenerationStateConfig();

    ObricAppIntentScreenshotCacheConfig getObricAppIntentScreenshotCacheConfig();

    ObricAppLogSettingsConfig getObricAppLogSettingsConfig();

    AutoGuiBlacklistConfig getObricAutoGuiBlacklistConfig();

    AutoIncreaseDelayedTimeConfig getObricAutoIncreaseDelayedTimeConfig();

    ObricBottomTabConfig getObricBottomTabConfig();

    JsonObject getObricCloudConfig(String r1);

    ComplexTaskCaseFromPCConfig getObricComplexTaskCaseFromPC();

    ObricCrashDumpHprofConfig getObricCrashDumpHprofConfig();

    String getObricFlowSettingsJson(String r1);

    ObricImageUploadCompressConfig getObricImageUploadCompressConfig();

    ObricLarkConfirmConfig getObricLarkConfirmSettingsConfig();

    ObricLazyInitConfig getObricLazyInitConfig();

    ObricLogSettingsConfig getObricLogSettingsConfig();

    ObricMemoryDataCollectConfig getObricMemoryDataCollectConfig();

    ObricMemoryReportConfig getObricMemoryReportConfig();

    ObricOneLoginConfig getObricOneLoginConfig();

    CPUExceptionDiagnosisConfig getObricPerformanceCPUExceptionDiagnosisSettingsConfig();

    ObricPerformanceMonitorConfig getObricPerformanceMonitorConfig();

    ObricPerformancePowerMonitorConfig getObricPerformancePowerMonitorSettingsConfig();

    ObricPowerLockConfig getObricPowerLockConfig();

    int getObricPowerLockTimeoutInSeconds();

    int getObricPrivacyLaneType();

    ObricProcessesManagerConfig getObricProcessesManagerConfig();

    q1 getObricPromptCellConfig();

    ObricScreenshotUploadConfig getObricScreenshotUploadConfig();

    ObricSecuritySettingsPackageWhitelistConfig getObricSecuritySettingsPackageWhitelistConfig();

    ObricSettingsConfig getObricSettingsConfig();

    ObricStateMachineMultitaskConfig getObricStateMachineMultitaskConfig();

    ObricTimeoutConfig getObricTaskTimeoutConfig();

    ObricThresholdDumpHprofConfig getObricThresholdDumpHprofConfig();

    ZeusAutoFetchConfig getObricZeusAutoFetchConfig();

    ObricActionBarItemsConfig getWindowActionBarItemsConfig();

    void h(boolean r1);

    void h0();

    void h1();

    boolean i();

    ComplexTaskSettingsConfig i0();

    void i1(boolean r1);

    boolean isBypassAdaptiveSid();

    boolean isCloseAudioConnAppBackGroundOnlyForObric();

    boolean isLarkKnowledgeAuthorizationEnable();

    boolean isObricContTalkPvadSwitchShowEnable();

    boolean isReRecordWakeWordGuideEnable();

    boolean isTtsPlayBackgroundEnabled();

    @Deprecated(message = "use getAuthenticationTypeOfAutoGuiExecuteOnLockScreen instead")
    boolean isVoicePrintAuthenticateAutoGuiEnabled();

    void j(String r1, g r2);

    boolean j0();

    void j1(boolean r1);

    void k();

    boolean k0(String r1);

    @ObricSettingsAuthenticationType
    int k1();

    void l(boolean r1, List<String> r2);

    void l0(int r1);

    void l1();

    List<ObricEnrolledDeviceInfo> m();

    boolean m0();

    void m1(int r1);

    void n(String r1);

    void n0(@RiskPreferenceSettings String r1);

    void n1(boolean r1);

    void o(long r1);

    boolean o0();

    boolean o1();

    String p();

    QueryAuthenticateConfig p0();

    boolean p1();

    boolean q();

    void q0(boolean r1);

    ObricDeepThinkModeRestTimeConfig q1();

    boolean r();

    boolean r0();

    boolean r1();

    int s(String r1);

    AutoGuiAppScopeConfig s0();

    boolean s1();

    void setAutoGuiEnabledScene(int r1);

    void setAutoImageUploadEnabled(boolean r1);

    void setOUseMemoryEnabled(boolean r1);

    void setSemanticScreenShotEnabled(boolean r1);

    @Deprecated(message = "use saveAuthenticationTypeOfAutoGuiExecuteOnLockScreen instead")
    void setVoicePrintAuthenticateAutoGuiEnabled(boolean r1);

    void t(@ObricSettingsAuthenticationType int r1);

    boolean t0();

    void t1(String r1);

    boolean u();

    boolean u0();

    void u1(boolean r1);

    Integer v();

    @ObricSettingsAuthenticationType
    int v0();

    boolean v1();

    void w(int r1);

    String w0();

    boolean w1();

    void x(boolean r1);

    boolean x0();

    ObricWakeupSoundConfig x1();

    void y(boolean r1);

    void y0(boolean r1);

    boolean y1();

    void z(boolean r1);

    Object z0();

    void z1(int r1);
}
