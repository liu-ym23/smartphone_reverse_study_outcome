package com.bytedance.ee.bear.middleground.drive.export;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DowngradeStrategy implements NonProguard {
    public int engineBufferActiveConsumeInterval;
    public int memberBufferActiveConsumeInterval;
    public int sendCursorDebounce;
    public int updateCursorLongThrottle;
    public int updateCursorShortThrottle;

    public DowngradeStrategy() {
    }

    public String toString() {
        return "DowngradeStrategy{send_cursor_debounce=" + this.sendCursorDebounce + ", update_cursor_short_throttle=" + this.updateCursorShortThrottle + ", update_cursor_long_throttle=" + this.updateCursorLongThrottle + ", member_buffer_active_consume_interval=" + this.memberBufferActiveConsumeInterval + ", engine_buffer_active_consume_interval=" + this.engineBufferActiveConsumeInterval + '}';
    }
}
